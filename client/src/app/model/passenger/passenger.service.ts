import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  public API = 'http://localhost:8080';
  passengers = this.http.get(this.API + '/list-utasok');

  constructor(private http: HttpClient) {
  }

  deletePassenger(id: number): Observable<any> {
    return this.http.delete(this.API + '/deletepassenger?passengerId=' + id);
  }

  getAll(): Observable<any> {
    return this.passengers;
  }

  get(id: string) {
  }

  save(passenger: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    result = this.http.post(this.API, passenger);
    return result;
  }

  remove(href: string) {
  }
}
