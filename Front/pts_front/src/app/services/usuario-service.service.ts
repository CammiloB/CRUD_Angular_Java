import { Injectable } from '@angular/core';

import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  private URL = "http://localhost:8080/users";

  constructor(private http: HttpClient) { }

  public getUsers(){
    return this.http.get<Usuario[]>(this.URL);
  }

  public addUser(user: Usuario){
    this.http.post<Usuario>(this.URL, user).subscribe(data => (console.log(data)));
  }

  public updateUser(user: Usuario){
    this.http.put<Usuario>(this.URL, user).subscribe(data => (console.log(data)));
  }

  public deleteUser(id: number){
    this.http.delete(this.URL+"?id="+id).subscribe(data => (console.log(data)));
  }
}
