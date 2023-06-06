import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PagesRoutingModule } from './pages-routing.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ButtonModule, CardModule, FormModule, GridModule, CarouselModule, HeaderModule, NavModule, NavbarModule, CalloutModule, FooterModule, AlertModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    HomeComponent,
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    CardModule,
    ButtonModule,
    GridModule,
    IconModule,
    FormModule,
    CarouselModule,
    HeaderModule,
    NavModule,
    NavbarModule,
    CalloutModule,
    FooterModule,
    AlertModule,
  ]
})
export class PagesModule {
}
