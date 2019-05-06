import { Component, OnInit } from '@angular/core';
import { User } from '../user';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
usr: User={
id: 1,
name: 'Ram',
age:19
};
  constructor() { }

  ngOnInit() {
  }

}
