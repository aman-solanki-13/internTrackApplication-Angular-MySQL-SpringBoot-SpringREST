import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MentorRoutingModule } from './mentor-routing.module';
import { MentorRegistrationComponent } from './mentor-registration/mentor-registration.component';
import { MentorLandingPageComponent } from './mentor-landing-page/mentor-landing-page.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    MentorRegistrationComponent,
    MentorLandingPageComponent,
  ],
  imports: [
    CommonModule,
    MentorRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class MentorModule { }
