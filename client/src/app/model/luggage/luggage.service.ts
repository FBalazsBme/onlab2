import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LuggageService {

  public API = 'http://localhost:8080';
  luggage = this.http.get(this.API + '/list-poggyasz');

  constructor(private http: HttpClient) {
  }

  deleteLuggage(id: number): Observable<any> {
    return this.http.delete(this.API + '/deleteluggage?luggageId=' + id);
  }

  getAll(): Observable<any> {
    return this.luggage;
  }

  get(id: string) {
  }

  save(luggage: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    result = this.http.post(this.API, luggage);
    return result;
  }

  remove(href: string) {
  }

}
