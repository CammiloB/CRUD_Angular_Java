import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl } from '@angular/forms';

import { RolServiceService } from '../../services/rol-service.service';
import { UsuarioServiceService } from '../../services/usuario-service.service';
import { Rol } from '../../models/rol';
import { Usuario } from '../../models/usuario';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public showInfoUser:boolean = true;
  public roles: any = null;
  public users: Usuario[];
  public busqueda: string = "";
  public userRol: number = 0;
  public activoInput = "";
  public isCreating: boolean = true;

  public profileForm = new FormGroup({
    id_usuario: new FormControl(''),
    id_rol: new FormControl(''),
    nombre: new FormControl(''),
    activo: new FormControl('')
  });

  constructor(private rolService: RolServiceService, private userService: UsuarioServiceService) {

   }

  ngOnInit(): void {
    this.rolService.getRoles().subscribe(roles => (this.roles = roles));
    this.getUsers();
  }

  public hiddenUserInfo(){
    this.profileForm.reset();
    //this.showInfoUser = !this.showInfoUser;
  }

  public getUsers(){
    this.userService.getUsers().subscribe(users => (this.users = users));
  }

  public createUser(){
    let user: Usuario = {
      id_usuario: 0, 
      id_rol: this.profileForm.value.id_rol, 
      nombre: this.profileForm.value.nombre,
      activo: this.profileForm.value.activo
    }
    this.userService.addUser(user);
    this.getUsers();
  }

  public updateUser(){
    let user: Usuario = {
      id_usuario: this.profileForm.value.id_usuario, 
      id_rol: this.profileForm.value.id_rol, 
      nombre: this.profileForm.value.nombre,
      activo: this.profileForm.value.activo
    }
    this.userService.updateUser(user);
    this.getUsers();
  }

  public deleteUser(){
    let id = this.profileForm.value.id_usuario;
    this.userService.deleteUser(id);
    this.getUsers();
  }

  public selectUser(user:Usuario){
    this.profileForm.get('id_usuario')?.setValue(user.id_usuario);
    this.profileForm.get('id_rol')?.setValue(user.id_rol);
    this.profileForm.get('nombre')?.setValue(user.nombre);
    this.profileForm.get('activo')?.setValue(user.activo);

    this.showInfoUser = false;
  }


}
