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
  public studentobj2: any ;
  public id2: number;
  public message:String;

  clickonme(){
    this.val=!this.val
  }
  constructor(private router:Router,private route:ActivatedRoute,private studentservice: StudentserviceService) { }
  
  
  ngOnInit() {
    this.id2=+this.route.snapshot.paramMap.get('this.user.id');
    this.getdetail();
  }
  public getdetail()
  {
    console.log(this.id2);
    this.studentservice.getprofile(this.id2).subscribe(studentobj2=> {
      this.studentobj2=studentobj2;
  });
  }

  public ondelete()
  {
    this.studentservice.deleteuser(this.studentobj2.id).subscribe(message=>{
    message= message;
    });
  }
  public onupdate()
  {
    this.studentservice.updateuser(this.studentobj2).subscribe(studentobj2=>{
      this.studentobj2=studentobj2;
    })
  }
}  
