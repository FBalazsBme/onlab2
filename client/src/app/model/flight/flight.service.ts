import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  public API = 'http://localhost:8080';
  flights = this.http.get(this.API + '/list-jaratok');

  constructor(private http: HttpClient) {
  }

  deleteFlight(id: number): Observable<any> {
    return this.http.delete(this.API + '/deleteflight?flightId=' + id);
  }

  getAll(): Observable<any> {
    return this.flights;
  }

  get(id: string) {
  }

  save(flight: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    result = this.http.post(this.API, flight);
    return result;
  }

  remove(href: string) {
  }



}
