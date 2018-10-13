import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '../../../node_modules/@angular/router';
import { HomeComponent } from '../home/home.component';
import { SignupComponent } from '../signup/signup.component';
import { LoginComponent } from '../login/login.component';
import { AuthService as AuthGuard } from '../core/auth.service';

const applicationRoutes:Routes = [
  {
    path:'',
    component:LoginComponent,
    data: {
      isBackButtonEnabled: false
    }
  },
  {
    path:'signup',
    component:SignupComponent,
    data: {
      isBackButtonEnabled: false
    }
  },
  {
    path:'home',
    component:HomeComponent,
    canActivate : [AuthGuard],
    data: {
      isBackButtonEnabled: true
    }
  }
];

@NgModule({
  imports: [
    CommonModule,RouterModule.forRoot(applicationRoutes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
