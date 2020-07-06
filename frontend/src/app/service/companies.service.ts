import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http'
import { Observable } from 'rxjs';
import { Company } from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class CompaniesService {

  private readonly API2 = 'http://localhost:8080';
  private readonly API = 'https://jsonplaceholder.typicode.com/todos/1';


  constructor(private http: HttpClient) { }


  getCompanies() : Observable<Company[]> {
    return this.http.get<Company[]>(this.API2+'/company')
  }

  list() {
    return this.http.get(this.API);
  }
}
