import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Credentials } from '../models/Credentials';
import { Login } from '../models/Login';
import { environment } from '../../environments/environment'
import { firstValueFrom } from 'rxjs';
import { ApplicationConstants } from '../constants/ApplicationConstants';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseService = `${environment.baseServer}/${ApplicationConstants.API_V1}/auth`
  constructor(private http: HttpClient) { }

  async login(login: Login): Promise<Credentials> {
    const request = this.http.post<Credentials>(this.baseService, login)
    return firstValueFrom<Credentials>(request)
  }

  async verifyAuthentication(): Promise<string> {
    const request = this.http.get<string>(this.baseService)
    return firstValueFrom<string>(request)
  }

}
