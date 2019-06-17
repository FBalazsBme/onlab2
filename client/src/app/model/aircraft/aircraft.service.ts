import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AircraftService {
  public API = 'http://localhost:8080';
  aircrafts = this.http.get(this.API + '/list-gepek');

  constructor(private http: HttpClient) {
  }

  deleteAircraft(id: number): Observable<any> {
    return this.http.delete(this.API + '/deleteaircraft?aircraftId=' + id);
  }

  getAll(): Observable<any> {
    return this.aircrafts;
  }

  get(id: string) {
  }

  save(aircraft: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    result = this.http.post(this.API, aircraft);
    return result;
  }

  remove(href: string) {
  }


}
