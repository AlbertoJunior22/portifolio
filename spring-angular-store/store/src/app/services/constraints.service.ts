import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FieldConstraints } from '../models/FieldConstraints';
import { environment } from '../../environments/environment'
import { firstValueFrom } from 'rxjs';
import { ApplicationConstants } from '../constants/ApplicationConstants';

@Injectable({
  providedIn: 'root'
})
export class ConstraintsService {

  private baseService = `${environment.baseServer}/${ApplicationConstants.API_V1}/constraints`

  constructor(private http: HttpClient) {
    
  }

  async retrieveFieldConstraints(): Promise<FieldConstraints> {
    const request = this.http.get<FieldConstraints>(`${this.baseService}/fields`)
    return await firstValueFrom(request)
  }

}
