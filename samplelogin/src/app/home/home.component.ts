import { Component, Input } from '@angular/core';
import { StudentserviceService} from '../studentservice.service';
import { ActivatedRoute,Router } from '@angular/router';
import {Userclass} from '../user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent{
  title = 'USER LOGIN';
  public studentobj: Userclass;
  public user= {
    id:null,
    name:'',
    gender:'',
    password:'',
    mobile:'',
    email:''
  }
  public b:boolean;
  public val=true;
  public studpass: string;
  public totalusers: Userclass[];
  public sample:any;
  public message:String;
  public me:any;
  public id1:number;

  constructor(private studentservice: StudentserviceService,private router:Router,private route:ActivatedRoute){}
  

  public getlogin()
  {
    this.studentservice.getlog(this.user).subscribe(message=> {
       
      this.message=message;
      this.id1=this.user.id;
      if((this.message)==("Successfull"))
      {
       console.log(this.message);
       //console.log(this.user.id);
       //Cookie[] cookies = request.getCookies();
       sessionStorage.setItem("id",String(this.user.id));
       this.router.navigate(['student-details/']);
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
  public emailpe()
  {
    if(this.user.id!=null)
    {
      this.studentservice.forgemail(this.user).subscribe(me=> {
        this.me=me;
        console.log(me);
      })
      alert("Your Password has been sent to your registered E-mail id");
    }
    else
    {
      alert("Please enter user id");
    }
  }
  public otppe()
  {
    if(this.user.id!=null)
    {
      alert("Your Password has been sent to your registered mobile number");
    }
    else
    {
      alert("Please enter user id");
    }
  }
}
  



