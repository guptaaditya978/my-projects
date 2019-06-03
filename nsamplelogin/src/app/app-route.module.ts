import { NgModule } from '@angular/core';
import { RouterModule, Routes, ChildrenOutletContexts } from '@angular/router';
import { StudentDetailsComponent } from './student-details/student-details.component';
import{StudentSignupComponent} from './student-signup/student-signup.component';
import {StudentsComponent} from './students/students.component';
import {OrderComponent} from './order/order.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'student-signup', component: StudentSignupComponent },
  { path: 'order/:id', component:OrderComponent},
  { path: 'students/:id', component: StudentsComponent }, 
  { path: 'student-details/:id', component: StudentDetailsComponent }
];

@NgModule({

  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRouteModule { }
