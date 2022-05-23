import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { InternServicesService } from 'src/app/_services/intern-services.service';


@Component({
  selector: 'app-intern-landing-page',
  templateUrl: './intern-landing-page.component.html',
  styleUrls: ['./intern-landing-page.component.css']
})
export class InternLandingPageComponent implements OnInit {
  isDailyStatusDivShown:boolean = true;
  isCompletedAssignmentDivShown:boolean = true;
  isIncompleteAssignmentDivShown:boolean = true;

  showDailyStatusDiv(){
    this.isDailyStatusDivShown = false;
    this.isCompletedAssignmentDivShown = true;
    this.isIncompleteAssignmentDivShown = true;
  }
  showCompletedAssignmentDiv(){
    this.isDailyStatusDivShown = true;
    this.isCompletedAssignmentDivShown = false;
    this.isIncompleteAssignmentDivShown = true;
  }
  showIncompleteAssignmentDiv(){
    this.isDailyStatusDivShown = true;
    this.isCompletedAssignmentDivShown = true;
    this.isIncompleteAssignmentDivShown = false;
  }

  // Injecting Intern Service and setting values
  internService: any;
  internId: string = ""; 
  internObject: any;
  

  constructor(internService: InternServicesService) { 

  this.internService = internService;
  this.internId = internService.internId;
  this.internObject = internService.internObject;
  }


  // Defining variables 
  allAssignmentsOfIntern:Array<any> = []
  allCompleteAssignmentsOfIntern:Array<any> = [];
  allIncompleteAssignmentsOfIntern:Array<any> = [];

  setAssignmentValues(){
    this.internService.listAssignmentsOfIntern().subscribe((data:any) => {
        this.allAssignmentsOfIntern = data;

        this.allIncompleteAssignmentsOfIntern = this.allAssignmentsOfIntern.filter(assgn => assgn.assignmentStatus==="Incomplete");
        this.allCompleteAssignmentsOfIntern = this.allAssignmentsOfIntern.filter(assgn => assgn.assignmentStatus==="Complete")
        
        console.log(`Incomplete assgn: ` + this.allIncompleteAssignmentsOfIntern.forEach(x => console.log(x.assignmentID)))
        console.log(`Complete assgn: ` + this.allCompleteAssignmentsOfIntern)
    })
  }

  markAssignmentComplete(assignmentID: any){
    this.internService.markAssignmentComplete(assignmentID).subscribe((bool: any) => alert(`Assignment with id: ${assignmentID} status changed to: Complete`));
  }

  uploadDailyStatus(formData: any, dailyStatusForm: NgForm){
    console.log(formData)
    this.internService.uploadDailyStatus(this.internId, formData.dailyStatusText).subscribe((bool: any) => alert('Daily Status uploaded'));
    dailyStatusForm.reset();

  }

  ngOnInit(): void {
  }

}
