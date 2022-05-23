import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MentorServicesService {
  mentorObject: any;

  mentorId:string = "";
  mentorPassword:string = "";
  mentorOf: string = "";

  private mentorUrl: string = "http://localhost:8080/mentor/";

  constructor(private httpClient:HttpClient) { }

  getMentorList(){
    return this.httpClient.get(`${this.mentorUrl}` + `mentorsList`)
  }

  getAllAssignmentsOfIntern(internId: any){
    return this.httpClient.get(`${this.mentorUrl}` + `allAssignmentsOfIntern` + `/${internId}`);
  }

  AllDailyStatusOfInter(internId: any){
    return this.httpClient.get(`${this.mentorUrl}` + `internDailyStatuses` + `/${internId}`);
  }

  getInternDetails(internId: any){
    return this.httpClient.get(`${this.mentorUrl}` + `getInternDetails` + `/${internId}`);
  }

  giveAssignment(assignmentText: any, givenBy: any, givenTo: any){
    return this.httpClient.get(`${this.mentorUrl}` + `giveAssignment` + `/${assignmentText}` + `/${givenBy}` + `/${givenTo}`);
    }

  saveNewMentor(mentorName: any, mentorId: any, mentorPassword: any, mentorOf: any){
    return this.httpClient.get(`${this.mentorUrl}` + `saveNewMentor` + `/${mentorName}` + `/${mentorId}` + `/${mentorPassword}` + `/${mentorOf}`)

  }

  ListOfInternsWithoutMentor(){
    console.log("CAlling service")
    return this.httpClient.get(`${this.mentorUrl}` + `internsWithoutAnyMentor`)
    
  }
}
