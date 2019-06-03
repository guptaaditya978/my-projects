import { Component, OnInit } from '@angular/core';
import { AppComponent } from '../app.component';
import{ Userclass } from '../user';
import{ Router } from '@angular/router';
import {StudentserviceService} from '../studentservice.service';

  @Component({
  selector: 'app-student-signup',
  templateUrl: './student-signup.component.html',
  styleUrls: ['./student-signup.component.css']
})
export class StudentSignupComponent implements OnInit {
  
  public user1= {
    id:0,
    name:' ',
    password:' '
  };



  constructor(private router:Router, private appcomponent:AppComponent, public studentservice:StudentserviceService) { }


  onsubmit(){
    this.studentservice.adduser(this.user1).subscribe(user1 => {
      console.log(user1);

      this.router.navigate(['/']);
    });
  }


  ngOnInit() {
  }

}
