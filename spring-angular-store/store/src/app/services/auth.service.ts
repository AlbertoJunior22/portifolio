import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Credentials } from '../models/Credentials';
import { Login } from '../models/Login';
import { environment } from '../../environments/environment'
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseService = `${environment.baseServer}/auth`
  constructor(private http: HttpClient) { }

  async login(login: Login): Promise<Credentials> {
    const request = this.http.post<Credentials>(this.baseService, login)
    return firstValueFrom<Credentials>(request)
  }

}
