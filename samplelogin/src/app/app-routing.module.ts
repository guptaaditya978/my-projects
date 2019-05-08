import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentSigninComponent } from './student-signin/student-signin.component';
const routes: Routes = [
  { path: 'student-detail', component: StudentDetailsComponent },
  {path: 'student-sign',component: StudentSigninComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
