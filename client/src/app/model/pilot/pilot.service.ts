import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PilotService {
  public API = '//localhost:8080';
  public PILOT_API = this.API + '/pilots';
  pilots = this.http.get(this.API + '/list-pilots');

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.pilots;
  }

  get(id: string) {
    return this.http.get(this.PILOT_API + '/' + id);
  }

  save(pilot: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    if (pilot[key]) {
      result = this.http.put(pilot.href, pilot);
    } else {
      result = this.http.post(this.PILOT_API, pilot);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }



}
