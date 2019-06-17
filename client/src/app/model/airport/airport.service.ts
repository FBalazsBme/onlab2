import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  public API = 'http://localhost:8080';
  airports = this.http.get(this.API + '/list-repterek');

  constructor(private http: HttpClient) {
  }

  deleteAirport(id: number): Observable<any> {
    return this.http.delete(this.API + '/deleteairport?airportId=' + id);
  }

  getAll(): Observable<any> {
    return this.airports;
  }

  get(id: string) {
  }

  save(airport: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    result = this.http.post(this.API, airport);
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
