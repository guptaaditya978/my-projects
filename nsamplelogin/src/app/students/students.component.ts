import { Component, OnInit } from '@angular/core';
import { inuser } from '../mock-user';
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
    password:''
  };
  public stud3:any;
  public id2: number;
  public message:any;

  clickonme(){
    this.val=!this.val
  }
  constructor(private router:Router,private route:ActivatedRoute,private studentservice: StudentserviceService) { }
  
  
  ngOnInit() {
    this.id2=+this.route.snapshot.paramMap.get('id');
    this.getdetail();
  }
  public getdetail()
  {
    console.log(this.id2);
    this.studentservice.getprofile(this.id2).subscribe(stud3=> {
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
}  
