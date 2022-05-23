import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InternRoutingModule } from './intern-routing.module';
import { InternRegistrationComponent } from './intern-registration/intern-registration.component';
import { InternLandingPageComponent } from './intern-landing-page/intern-landing-page.component';
import { NavbarComponent} from '.././navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    InternRegistrationComponent,
    InternLandingPageComponent,
    // NavbarComponent
  ],
  imports: [
    CommonModule,
    InternRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class InternModule { }
