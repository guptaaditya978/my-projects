import { Component, Input } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // title = 'USER LOGIN';
  // public studentobj: Userclass;
  // public user= {
  //   id:0,
  //   name:'',
  //   password:''
  // };
  // public b:boolean;
  // public val=true;
  // public studpass: string;
  // public totalusers: Userclass[];
  // public sample:any;
  // public message:String;
  // public id1:number;

  constructor(){}
  

//   public getlogin()
//   {
//     this.studentservice.getlog(this.user).subscribe(message=> {
       
//       this.message=message;
//       this.id1=this.user.id;
//       if((this.message)==("Successfull"))
//       {
//        console.log(this.message);
//        this.router.navigate(['student-details/' + this.id1]);
//       }
//       else if((this.message)==("Unsuccessfull")){
//        console.log(this.message);
//        this.router.navigate(['/']);
//       }
//       else{
//        console.log(this.message);
//        this.router.navigate(['/']);
//       }
//      this.b=(this.message)==("Successfull");
//      console.log(this.b);
    
    
//     })
//   }
// //  public display()
// //   {
// //     this.studentservice.getUsers().subscribe(totalusers=>{
// //       this.totalusers=totalusers;
// //       this.val=true;
// //       console.log(this.totalusers);
// //     });
// //   }

}
