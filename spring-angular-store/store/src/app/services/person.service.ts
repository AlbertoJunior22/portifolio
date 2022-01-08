import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Person } from '../models/Person';
import { BaseService } from './base.service';
import { IBaseService } from './base.service.interface';

@Injectable({
  providedIn: 'root'
})
export class PersonService extends BaseService<Person> implements IBaseService<Person> {

  constructor(http: HttpClient) { 
    super(http, 'person')
  }
  
}
