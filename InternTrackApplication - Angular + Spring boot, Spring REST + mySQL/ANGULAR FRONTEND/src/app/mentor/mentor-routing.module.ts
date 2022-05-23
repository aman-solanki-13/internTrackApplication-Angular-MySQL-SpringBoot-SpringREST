import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MentorRegistrationComponent} from './mentor-registration/mentor-registration.component';
import { MentorLandingPageComponent} from './mentor-landing-page/mentor-landing-page.component';
const routes: Routes = [
  {path: 'mentorRegistration', component: MentorRegistrationComponent},
  {path: 'mentorLandingPage', component: MentorLandingPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MentorRoutingModule { }
