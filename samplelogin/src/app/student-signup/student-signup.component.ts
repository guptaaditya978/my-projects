import { Component, OnInit } from '@angular/core';
//import { HomeComponent } from  '../home/home.component';
import{ Userclass } from '../user';
import{ Router,ActivatedRoute } from '@angular/router';
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
    gender:' ',
    password:'',
    mobile:' ',
    email:' '
  };



  constructor(private route:ActivatedRoute,private router:Router, public studentservice:StudentserviceService) { }


  onsubmit(){
    this.studentservice.adduser(this.user1).subscribe(user1 => {
      console.log(user1);

      this.router.navigate(['/']);
    });
  }


  ngOnInit() {
  }

}
