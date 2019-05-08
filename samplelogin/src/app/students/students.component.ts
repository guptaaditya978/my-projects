import { Component, OnInit } from '@angular/core';
import { inuser } from '../mock-user';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  public user=inuser;
  public val=false;

  clickme(){
    this.val=!this.val
  }
  constructor() { }

  ngOnInit() {
  }

}
