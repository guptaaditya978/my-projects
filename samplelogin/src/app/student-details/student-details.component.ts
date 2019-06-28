import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router} from '@angular/router';
import { Userclass } from '../user';
import { StudentserviceService} from '../studentservice.service';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { TouchSequence } from 'selenium-webdriver';


@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  public id1: number ;
  public usersdetails: Userclass;
  id2: any;
  stud3: Object;
  constructor(private router:Router,private route:ActivatedRoute,private studentservice:StudentserviceService) {  }
  
  
  /*getUsers(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.studentservice.getUsersbyid(id)
      .subscribe(hero => this.hero = hero);
  }*/

  ngOnInit() {
    //this.getUsers();
    if(sessionStorage.getItem("id")!=null)
    {
    //this.id1=+this.route.snapshot.paramMap.get('id');
    console.log(parseInt(sessionStorage.getItem("id")));
    //this.route.params.subscribe(params => this.empid = params.empid);
    //this.detail();
    //console.log(this.id1);
    }
    else{
      this.router.navigate(['/']);
    }
  }

//   detail()
//   {
//     this.studentservice.getprofile(this.id1).subscribe(stud3=> {
//       this.stud3 = stud3;
//   });
// }
  public profile()
  {
    //this.router.navigateByUrl("/student-details/id");
    this.router.navigate(['students/']);
    
  }
   public logout()
   {
    sessionStorage.clear();
    this.studentservice.logou().subscribe(m=>{
      this.router.navigate(['/']);
    });
    
   }

}
