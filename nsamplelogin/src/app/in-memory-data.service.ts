import { Injectable } from '@angular/core';
import { Userclass } from './user';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService {
  createDb() {
    const Users = [
    {id:101, name:'A', password:"1"},
    {id:102, name:'B', password:"12"},
    {id:103, name:'C', password:"123"},
    {id:104, name:'D', password:"1234"},
    {id:105, name:'E', password:"12345"},
    {id:106, name:'F', password:"12346"}
    ];
    return {Users};
  }
  constructor() { }

}
