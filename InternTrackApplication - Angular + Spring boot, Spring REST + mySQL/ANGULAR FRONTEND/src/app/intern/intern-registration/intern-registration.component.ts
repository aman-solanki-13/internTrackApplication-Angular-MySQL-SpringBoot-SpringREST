import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { InternServicesService } from 'src/app/_services/intern-services.service';

@Component({
  selector: 'app-intern-registration',
  templateUrl: './intern-registration.component.html',
  styleUrls: ['./intern-registration.component.css']
})
export class InternRegistrationComponent implements OnInit {

  //Creating services and injecting values
  internService: InternServicesService;
  constructor(internService: InternServicesService) {
      this.internService = internService;
   }

   //Creating variables and arrays
  allInterns: Array<any> = [];
  success: boolean = false;

  processInternRegistration(formValues: any, form: NgForm){
  const internName = formValues.internName;
  const internId = formValues.internId;  
  const internPassword = formValues.internPassword;
  const internReEnterPassword = formValues.internReEnterPassword;
  const internGender = formValues.internGender;

  this.internService.getInternList().subscribe((data: any) => {
    this.allInterns = data;
    if(this.allInterns.length==0){
      this.success= true;
      if(internPassword === internReEnterPassword){
        this.internService.saveNewIntern(internName, internId, internPassword, internGender).subscribe(data =>
          alert(`Intern with id ${internId} registered successfully`))
          form.reset();
      }else{
        alert(`Password and ReEnter password field values doen't match`)
      }
      
    }else{
      const internMatch = this.allInterns.filter(i => (i.internId === formValues.internId));
      if(internMatch.length == 0){
        if(internPassword === internReEnterPassword){
          this.internService.saveNewIntern(internName, internId, internPassword, internGender).subscribe(data =>
            alert(`Intern with id ${internId} registered successfully`));  
            form.reset();
        }else{
          alert(`Password and ReEnter password field values doen't match`)
        }
        
      }else{
        this.success = false;
        alert(`Intern with id: ${internId} already exist, Please sign in instead`);
      }
    }

  })

  }


  ngOnInit(): void {
  }

}
