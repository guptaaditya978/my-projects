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
public studentobj3:any;

  constructor(private router:Router,private route:ActivatedRoute,private studentservice: StudentserviceService) { }

  ngOnInit() {
    this.oid=+this.route.snapshot.paramMap.get('id');
    //this.studentobj3=this.studentservice.getdet(this.oid);
    //console.log(this.studentobj3.id);
  }

}
