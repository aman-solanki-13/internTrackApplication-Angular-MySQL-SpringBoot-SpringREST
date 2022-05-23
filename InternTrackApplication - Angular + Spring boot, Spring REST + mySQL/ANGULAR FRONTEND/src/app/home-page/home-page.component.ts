import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InternServicesService } from '../_services/intern-services.service';
import { MentorServicesService } from '../_services/mentor-services.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements OnInit {
  //variables 
  success:boolean = true;

  //Data from service
  internsList:Array<any> = [];
  mentorsList:Array<any> = [];
  allInternsWithoutMentor: Array<any> = [];
  // internsIdList:Array<any> = [];

  //Injecting Services
  private internService:any;
  private mentorService:any;
  private router:Router;
  constructor(internService: InternServicesService, mentorService:MentorServicesService, router:Router) { 
    this.internService = internService;
    this.mentorService = mentorService;
    this.router = router;
  }

  ngOnInit(): void {
  }
  
  loadRegistrationPage(){
    console.log(`1` + this.allInternsWithoutMentor)
    this.mentorService.ListOfInternsWithoutMentor().subscribe((data: any) => {
      this.allInternsWithoutMentor = data
      console.log(`data:: ` + this.allInternsWithoutMentor)
      if(this.allInternsWithoutMentor.length==0){
        alert(`There is not intern available without mentor, Please create Intern first`);
      }else{
          this.router.navigate(['mentor/mentorRegistration'])
      }
      console.log(`2` + data);
    }
      
      )
  }


  processInternLogin(values:any){
    // alert(`Name: ${values.internLoginId} and Password: ${values.internLoginPassword}`)
    // alert(`Hello ${values.internLoginId}`)
    console.log(values);
  this.internService.internId = values.internLoginId;
  this.internService.internPassword = values.internLoginPassword;

  this.internService.getInternList().subscribe((data:any) => {
    this.internsList = data ;
    console.log(data)

    if(this.internsList.length==0){
      this.success= false;
      alert(`Database in empty`)
  }else{
      const internMatch = this.internsList.filter(i => (i.internId === values.internLoginId && i.internPassword === values.internLoginPassword));
      console.log(internMatch)
      
      if(internMatch.length==0){
        this.success = false;
        alert(`Wrong Id entered`)
      }else{
        this.internService.internObject = internMatch;
        this.success = true;

        if(this.success == true){
            this.router.navigate(['/intern/internLandingPage'])
        }else{
          alert("Something went wrong")
        }
      
      }
  }
  });
  // console.log(this.success);

}

  processMentorLogin(values:any){
    alert(`Name: ${values.mentorLoginId} and Password: ${values.mentorLoginPassword}`)
    // alert(`Hello ${values.internLoginId}`)
    console.log(values);
  this.mentorService.mentorId = values.mentorLoginId;
  this.mentorService.mentorPassword = values.mentorLoginPassword;

  this.mentorService.getMentorList().subscribe((data:any) => {
    this.mentorsList = data ;
    console.log(data)

    if(this.mentorsList.length==0){
      this.success= false;
      alert(`Database in empty`)
  }else{
      const mentorMatch = this.mentorsList.filter(i => (i.mentorId === values.mentorLoginId && i.mentorPassword === values.mentorLoginPassword));
      console.log(mentorMatch)
      
      if(mentorMatch.length==0){
        this.success = false;
        alert(`Wrong Id entered`)
      }else{
        this.mentorService.mentorObject = mentorMatch;
        this.success = true;
        
        if(this.success == true){
          this.mentorService.mentorOf = this.mentorService.mentorObject[0].mentorOf;
          console.log(this.mentorService.mentorId);
            this.router.navigate(['/mentor/mentorLandingPage'])
        }else{
          alert("Something went wrong")
        }
      
      }
  }
  });
  // console.log(this.success);

  }

}
