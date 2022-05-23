import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {InternRegistrationComponent} from './intern-registration/intern-registration.component';
import {InternLandingPageComponent} from './intern-landing-page/intern-landing-page.component'

const routes: Routes = [
  {path: 'internRegistration', component: InternRegistrationComponent},
  {path: 'internLandingPage', component: InternLandingPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InternRoutingModule { }
