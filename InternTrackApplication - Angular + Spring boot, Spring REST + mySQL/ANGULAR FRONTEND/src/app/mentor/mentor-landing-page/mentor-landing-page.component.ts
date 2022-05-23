import { Component, OnInit} from '@angular/core';
import { NgForm } from '@angular/forms';
import { ConnectableObservable } from 'rxjs';
import { MentorServicesService } from 'src/app/_services/mentor-services.service';



@Component({
  selector: 'app-mentor-landing-page',
  templateUrl: './mentor-landing-page.component.html',
  styleUrls: ['./mentor-landing-page.component.css']
})
export class MentorLandingPageComponent implements OnInit {
  isInternDetailDivShown: boolean = true;
  isAssignmentStatusDivShown: boolean = true;
  isGiveAssignmentDivShown: boolean = true;
  isViewDailyStatusDivShown: boolean = true;

  showInternDetailDiv(){
    this.isInternDetailDivShown = false;
    this.isAssignmentStatusDivShown = true;
    this.isGiveAssignmentDivShown = true;
    this.isViewDailyStatusDivShown = true;
  }
  showAssignmentStatusDiv(){
    this.isInternDetailDivShown = true;
    this.isAssignmentStatusDivShown = false;
    this.isGiveAssignmentDivShown =  true;
    this.isViewDailyStatusDivShown = true
  }
  showGiveAssignmentDiv(){
    this.isInternDetailDivShown = true;
    this.isAssignmentStatusDivShown = true;
    this.isGiveAssignmentDivShown = false;
    this.isViewDailyStatusDivShown = true;
  }
  showDailyStatusDiv(){
    this.isInternDetailDivShown = true;
    this.isAssignmentStatusDivShown = true;
    this.isGiveAssignmentDivShown = true;
    this.isViewDailyStatusDivShown = false;
  }

  // Injecting Mentor Service and setting values
  mentorService: any;
  mentorId: any;
  mentorOf: any;

    constructor(mentorService: MentorServicesService) { 
    this.mentorService = mentorService;
    this.mentorId = mentorService.mentorId;
    this.mentorOf = mentorService.mentorOf;
  }

  // Defining variables 
  allAssignmentsOfIntern: Array<any> = [];
  allDailyStatusOfIntern: Array<any> = [];
  intern: any = [];

  showAllAssignments(){
    this.mentorService.getAllAssignmentsOfIntern(this.mentorOf).subscribe((data: any) => 
    this.allAssignmentsOfIntern = data);
  }

  showAllDailyStatusOfIntern(){
    this.mentorService.AllDailyStatusOfInter(this.mentorOf).subscribe((data: any) =>
    this.allDailyStatusOfIntern = data);
    console.log(this.allDailyStatusOfIntern);
  }

  showInternDetails(){
    this.mentorService.getInternDetails(this.mentorOf).subscribe((data: any) => 
    this.intern = data
    );
  }

  giveAssignment(formData: any, giveAssignmentForm: NgForm){
    this.mentorService.giveAssignment(formData.assignmentTextArea, this.mentorId, this.mentorOf).subscribe((data: any) =>
    alert(`Assignment given successfully`));
    giveAssignmentForm.reset();
  }

  ngOnInit(): void {
  }

}
