import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MentorServicesService } from 'src/app/_services/mentor-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mentor-registration',
  templateUrl: './mentor-registration.component.html',
  styleUrls: ['./mentor-registration.component.css']
})
export class MentorRegistrationComponent implements OnInit {

  //Creating services and injecting values
  mentorService: MentorServicesService;
  router:Router;
  constructor(mentorSerice: MentorServicesService, router:Router) { 
    this.mentorService = mentorSerice;
    this.router = router;
  }

  // Creating fields and Arrays
  allInternsWithoutMentor: Array<any> = [];
  allMentors: Array<any> = [];

  mentorName:any ;
  mentorId: any ;
  mentorPassword: any ;
  mentorReEnterPassword: any ;
  mentorOf: any;

  processMentorRegistration(formValues: any, form: NgForm){
    console.log(this.allInternsWithoutMentor);
    this.mentorName = formValues.mentorName;
    this.mentorId = formValues.mentorId;
    this.mentorOf = formValues.mentorOf;
    this.mentorPassword = formValues.mentorPassword;
    this.mentorReEnterPassword = formValues.mentorReEnterPassword;

    this.mentorService.getMentorList().subscribe((data: any) => {
      this.allMentors = data;
      if(this.allInternsWithoutMentor.length==0){
        alert(`There is not intern available without mentor, Please create Intern first`)
      }else{
      if(this.allMentors.length == 0){
        if(this.mentorPassword === this.mentorReEnterPassword){
          this.mentorService.saveNewMentor(this.mentorName, this.mentorId, this.mentorPassword, this.mentorOf).subscribe(data =>
            alert(`Mentor with id: ${this.mentorId} registered successfully`))
            form.reset();
        }else{
          alert(`Password and ReEnter password field values doen't match`)
        }
      }else{
        const internMatch = this.allMentors.filter(i => (i.mentorId === formValues.mentorId));
        if(internMatch.length == 0){
          if(this.mentorPassword === this.mentorReEnterPassword){
            this.mentorService.saveNewMentor(this.mentorName, this.mentorId, this.mentorPassword, this.mentorOf).subscribe(data =>
              alert(`Mentor with id: ${this.mentorId} registered successfully`))
              form.reset();
          }else{
            alert(`Password and ReEnter password field values doen't match`)
          }
          
        }else{
          alert(`Mentor with id: ${this.mentorId} already exist, Please sign in instead`);
        }
      }
      }
  
    })

  
  }

  //event handler for the select element's change event
  selectChangeHandler (event: any) {
    //update the ui
    this.mentorOf = event.target.value;
  }

  loadInternsWithoutMentorList(){
    console.log(`1` + this.allInternsWithoutMentor)
    this.mentorService.ListOfInternsWithoutMentor().subscribe((data: any) => {
      this.allInternsWithoutMentor = data
      console.log(`2` + data);
    }
      
      )
  }

  ngOnInit(): void {
    this.loadInternsWithoutMentorList();

    // console.log(`3` +  this.allInternsWithoutMentor);
    // if(this.allInternsWithoutMentor.length==0){
    //   alert(`There is not intern available without mentor, Please create Intern first`);
    //   this.router.navigate(['']);
    // }
  }

}
