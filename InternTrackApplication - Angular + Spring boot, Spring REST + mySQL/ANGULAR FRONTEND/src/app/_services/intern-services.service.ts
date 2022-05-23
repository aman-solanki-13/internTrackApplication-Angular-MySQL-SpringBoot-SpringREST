import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Intern } from '../_models/intern.model';

@Injectable({
  providedIn: 'root'
})
export class InternServicesService {

  internObject: any;

  internId:string = "";
  internPassword: string = "";

  private internUrl: string = "http://localhost:8080/intern/";

  constructor(private httpClient:HttpClient) {}

  getInternList() {
    return this.httpClient.get(`${this.internUrl}` + `internsList`);
  }

  saveIntern(intern: Object): Observable<Object>{
    return this.httpClient.post(`${this.internUrl}` + `saveIntern`, intern);
  }

  listAssignmentsOfIntern(){
    return this.httpClient.get(`${this.internUrl}` + `assignments` + `/${this.internId}`);
  }

  markAssignmentComplete(assignmentID:any){
    return this.httpClient.get(`${this.internUrl}` + `UpdateAssignmentStatus` + `/${assignmentID}`);
  }

  uploadDailyStatus(statusOf: string, status: string){
    return this.httpClient.get(`${this.internUrl}` + `giveDailyStatus` + `/${statusOf}` + `/${status}`)
  }

  saveNewIntern(internName: any, internId: any, internPassword: any, internGender: any){
    return this.httpClient.get(`${this.internUrl}` + `saveNewIntern` + `/${internName}` + `/${internId}` + `/${internPassword}` + `/${internGender}`)
  }
}
