import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { StudentsComponent } from './students/students.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { AppComponent } from './app.component';
import { AppRouteModule } from './app-route.module';
import { StudentSignupComponent } from './student-signup/student-signup.component';
import { OrderComponent } from './order/order.component';
import {StudentserviceService} from './studentservice.service';
import { HttpClientModule }    from '@angular/common/http';

//import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
//import { InMemoryDataService }  from './in-memory-data.service';

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    StudentDetailsComponent,
    StudentSignupComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRouteModule,
    HttpClientModule,
    ],
  providers: [StudentserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
