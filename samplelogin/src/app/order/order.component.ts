import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {StudentserviceService} from '../studentservice.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
public oid:number;
public orders:any;
public studentobj3:any;

  constructor(private router:Router,private route:ActivatedRoute,private studentservice: StudentserviceService) { }

  ngOnInit() {
  if(sessionStorage.getItem("id")!=null)
  {
  //this.id1=+this.route.snapshot.paramMap.get('id');
  console.log(parseInt(sessionStorage.getItem("id")));
  //this.route.params.subscribe(params => this.empid = params.empid);
  //this.detail();
  //console.log(this.id1);
  }
  }
  public logout()
   {
    sessionStorage.clear();
    this.studentservice.logou().subscribe(m=>{
      this.router.navigate(['/']);  
    });
    
   }

}
