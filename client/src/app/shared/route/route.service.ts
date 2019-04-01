import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class RouteService {
  public API = '//localhost:8080';
  public ROUTE_API = this.API + '/routes';
  routes = this.http.get(this.API + '/route-list');

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.routes;
  }

  get(id: string) {
    return this.http.get(this.ROUTE_API + '/' + id);
  }

  save(route: any): Observable<any> {
    let result: Observable<object>;
    const key = 'href';
    if (route[key]) {
      result = this.http.put(route.href, route);
    } else {
      result = this.http.post(this.ROUTE_API, route);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
