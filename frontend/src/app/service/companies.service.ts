import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http'
import { Observable } from 'rxjs';
import { Company } from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class CompaniesService {

  private readonly API = 'http://localhost:8080';


  constructor(private http: HttpClient) { }


  getCompanies() : Observable<Company[]> {
    return this.http.get<Company[]>(this.API+'/company')
  }

}
