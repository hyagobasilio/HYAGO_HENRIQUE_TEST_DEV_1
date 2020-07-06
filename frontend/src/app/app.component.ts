import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CompaniesService } from './service/companies.service';
import { Company } from './models/company';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  {
  
  title = 'frontend';
  companies : Company[];


  constructor(private companiesService: CompaniesService){}



  candidate = 'Candidato 1';

  getCompanies() {
    this.companiesService.getCompanies().subscribe(result => {
      this.companies = result;
    })
  }
}
