import { Component, OnInit } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import {Router , ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  public val=false;
  public studentobj2={
    id:0,
    name:'',
    gender:'',
    password:'',
    mobile:'',
    email:''
  };
  public stud3:any;
  public id2: number;
  public message:any;

  clickonme(){
    this.val=!this.val
  }
  constructor(private router:Router,private route:ActivatedRoute,private studentservice: StudentserviceService) { }
  
  
  ngOnInit() {
    if(sessionStorage.getItem("id")!=null)
    {
    //this.id1=+this.route.snapshot.paramMap.get('id');
    console.log(parseInt(sessionStorage.getItem("id")));
    //this.route.params.subscribe(params => this.empid = params.empid);
    //this.detail();
    //console.log(this.id1);
    this.getdetail();
    }
    
  }
  public getdetail()
  {
    //console.log(this.id2);
    this.studentservice.getprofile().subscribe(stud3=> {
    this.stud3 = stud3;
    this.studentobj2=this.stud3;  
    console.log(this.studentobj2);
  });
  }

  public ondelete()
  {
    this.studentservice.deleteuser(this.studentobj2.id).subscribe(message=>{
    this.message= message;
    console.log(this.message);
    sessionStorage.clear();
    this.router.navigate(['/']);
    });
  }
  public onupdate()
  {
    this.studentservice.updateuser(this.studentobj2).subscribe(stud3=>{
      this.stud3=stud3;
      this.studentobj2=this.stud3;
      console.log(this.studentobj2);
    })
  }
  public logout()
   {
    sessionStorage.clear();
    this.studentservice.logou().subscribe(m=>{
      this.router.navigate(['/']);
    });
    
   }
}  
