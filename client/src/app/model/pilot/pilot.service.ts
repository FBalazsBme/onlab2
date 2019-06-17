import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Pilot} from '@app/_models/pilot';

@Injectable({
  providedIn: 'root'
})
export class PilotService {
  public API = 'http://localhost:8080';
  pilots = this.http.get(this.API + '/list-pilots');

  constructor(private http: HttpClient) {
  }

  deletePilot(id: number): Observable<any> {
    return this.http.delete(this.API + '/deletepilot?pilotId=' + id);
  }


  getAll(): Observable<any> {
    return this.pilots;
  }

  get(id: string) {
    return this.http.get(this.API + '/findpilot?pilotId=' + id);
  }

  save(pilot: Pilot): Observable<any> {
    return this.http.post<any>(this.API + '/addpilot', pilot);
  }

  remove(href: string) {
    return this.http.delete(href);
  }



}
