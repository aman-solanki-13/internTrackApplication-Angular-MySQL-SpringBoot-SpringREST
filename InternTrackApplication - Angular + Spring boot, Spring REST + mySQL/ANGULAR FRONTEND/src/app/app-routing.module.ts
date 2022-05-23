import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomePageComponent} from './home-page/home-page.component';
import {ErrorPageComponent} from "./error-page/error-page.component";

// Lazy loading the component 
const mentorModule = () => import('./mentor/mentor.module').then(x => x.MentorModule);
const internModule = () => import('./intern/intern.module').then(x => x.InternModule);

const routes: Routes = [
  {path: '', component: HomePageComponent}, //Default Router
  {path: 'intern', loadChildren: internModule},
  {path: 'mentor', loadChildren: mentorModule},
  {path: '**', component: ErrorPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
