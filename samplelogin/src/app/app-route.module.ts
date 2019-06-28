import { NgModule } from '@angular/core';
import { RouterModule, Routes, ChildrenOutletContexts } from '@angular/router';
import { StudentDetailsComponent } from './student-details/student-details.component';
import{ StudentSignupComponent } from './student-signup/student-signup.component';
import { StudentsComponent } from './students/students.component';
import { OrderComponent } from './order/order.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'student-signup', component: StudentSignupComponent },
  { path: 'order', component:OrderComponent},
  { path: 'students', component: StudentsComponent }, 
  { path: 'student-details', component: StudentDetailsComponent }
];

@NgModule({

  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRouteModule { }
