import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UService {
  public API = 'localhost:8080';
  public USER_API = this.API + '/find-username';
  public CHECKER_API = this.API + '/checklogin';
  users = this.http.get(this.API + '/list-users');

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.users;
  }

  get(username: string) {
    return this.http.get(this.USER_API + '?userName=' + username);
  }

  getHash(username: string, password: string): Observable<any> {
    return this.http.get(this.CHECKER_API + '?userName=' + username +
    '&password=' + password);
  }

  save(user: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    if (user[key]) {
      result = this.http.put(user.href, user);
    } else {
      result = this.http.post(this.USER_API, user);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }

}
