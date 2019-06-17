import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';

import { environment } from '@environments/environment';
import { User } from '@app/_models';
import { UService} from '@app/shared/user/u.service';
import {Observable, Subscription, throwError} from 'rxjs';
import {catchError, first, map} from 'rxjs/operators';
import {OnDestroy} from '@angular/core/src/metadata/lifecycle_hooks';
import {RegisterComponent} from '@app/register';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Injectable({ providedIn: 'root' })
export class UserService implements OnDestroy {
  registerForm: FormGroup;
    users: Array<any>;
    subscriptions: Subscription[];

    pw = 'teszt';

    public API = 'localhost:8080';

    public CHECKER_API = this.API + '/checklogin';

    constructor(private http: HttpClient,
                private formBuilder: FormBuilder,
                private uservice: UService) { }


    getAllFromBackend(): Observable<User[]> {
      return this.http.get<User[]>(`${environment.backendUrl}/list-users`);
    }

  registerComponent(id, firstName, lastName, username, password, staff, admin): Subscription {
    return this.register({ id: id,
      username: username,
      password: password,
      firstName: firstName,
      lastName: lastName,
      staff: staff,
      admin: admin} as any)
      .pipe(first())
      .subscribe(
        data => {
        },
        error => {
        });
  }

    registerAllFromBackend() {
      this.getAllFromBackend().subscribe(data => {
        this.users = data;
        for (const user of this.users) {
          let subscription: Subscription;
          subscription = this.registerComponent(
            user.id,
            user.firstName,
            user.lastName,
            user.username,
            user.password,
            user.staff,
            user.admin);
          this.subscriptions.push(subscription);
          console.log(user.username);
        }
      });
    }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/users`);
    }

    getById(id: number) {
        return this.http.get(`${environment.apiUrl}/users/${id}`);
    }

    register(user: User) {

        return this.http.post<any>(`${environment.backendUrl}/adduser`, user);
    }

    update(user: User) {
        return this.http.put(`${environment.apiUrl}/users/${user.id}`, user);
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`);
    }

    getHash(url: string): Observable<any> {/*
      return this.uservice.getHash(username, password);*/
      return this.http.get(url);
    }
    private extractData(res: Response) {
      let body = res;
      return body || {};
    }
    private handleError(error: HttpErrorResponse) {
      if (error.error instanceof ErrorEvent) {
        // A client-side or network error occurred. Handle it accordingly.
        console.error("An error occurred:", error.error.message);
      } else {
        // The backend returned an unsuccessful response code. The response body may contain clues as to what went wrong,
        console.error(
          `Backend returned code ${error.status}, ` + `body was: ${error.error}`
        );
      }
      // return an observable with a user-facing error message
      return throwError(error);
    }

    ngOnDestroy() {
      for (const subsc of this.subscriptions) {
        subsc.unsubscribe();
      }
    }


}
