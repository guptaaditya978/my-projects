import { Component, OnInit } from '@angular/core';
import { inuser } from '../mock-user';
import {ActivatedRoute,Router} from '@angular/router';
import { Userclass } from '../user';
import { StudentserviceService} from '../studentservice.service';


@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  public id1: number ;
  public usersdetails: Userclass;
  constructor(private router:Router,private route:ActivatedRoute,private studentservice:StudentserviceService) {  }
  
  
  /*getUsers(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.studentservice.getUsersbyid(id)
      .subscribe(hero => this.hero = hero);
  }*/

  ngOnInit() {
    //this.getUsers();
    this.id1=+this.route.snapshot.paramMap.get('id');
    //this.route.params.subscribe(params => this.empid = params.empid);
  }
  public profile()
  {
    //this.router.navigateByUrl("/student-details/id");
    this.router.navigate(['students/'+ this.id1]);
    
  }
  

}
