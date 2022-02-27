import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { Rol } from '../models/rol';

@Injectable({
  providedIn: 'root'
})
export class RolServiceService {

  private URL = "http://localhost:8080/roles";

  constructor(private http: HttpClient) { }

  public getRoles(): Observable<any>{
    return this.http.get<any>(this.URL);
  } 
}
