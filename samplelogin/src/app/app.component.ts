import { Component, Input } from '@angular/core';
import { StudentserviceService} from './studentservice.service';
import { Router } from '@angular/router';
import {Userclass} from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'USER LOGIN';
  public studentobj: Userclass;
  public user= {
    id:0,
    name:'',
    password:''
  };
  public b:boolean;
  public studpass: string;
  public totalusers: Userclass[];
  public sample:any;
  public message:String;
  public id1:number;

  constructor(private studentservice: StudentserviceService,private router:Router){}
  

  public getlogin()
  {
    this.studentservice.getlog(this.user).subscribe(message=> {
       
      this.message=message;
      if((this.message)==("Successfull"))
      {
       console.log(this.message);
       this.router.navigate(['student-details/' + this.user.id]);
      }
      else if((this.message)==("Unsuccessfull")){
       console.log(this.message);
       this.router.navigate(['/']);
      }
      else{
       console.log(this.message);
       this.router.navigate(['/']);
      }
     this.b=(this.message)==("Successfull");
     console.log(this.b);
    
    
    })
  }

//   public getdetail() {

//     this.studentservice.getUsers(this.studentobj).subscribe(user1=>{this.user1 = user1});
//     console.log(this.user1);
// //    this.router.navigate(['/student-details',this.id]);
    
//   }
 }
