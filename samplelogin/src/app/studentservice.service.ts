import { Injectable } from '@angular/core';

import{Userclass} from './user';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators';
//import { Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class StudentserviceService {
//public user: Userclass;
public sampleuserByid:any;

constructor(private http: HttpClient) { }
 

  // getUsers(): Observable <any>
  // {
  // return this.http.get('http://localhost:8080/loginform/userlogin?').pipe(map( res => res ));
  // }
  getlog(user2): Observable <any>
  {
  return this.http.post('http://35.232.128.150:8080/loginform1/userlogin', user2).pipe(map( res => res ));
  }
  adduser(user2)
  {
    return this.http.post('http://35.232.128.150:8080/loginform1/signup', user2).pipe(map(res=>res));
  }
  getprofile()
  {
    return this.http.get('http://35.232.128.150:8080/loginform1/profile').pipe(map(res=>res));
  }
  deleteuser(id2)
  {
    return this.http.delete('http://35.232.128.150:8080/loginform1/userlogin?id='+id2).pipe(map(res=>res));  
  }
  updateuser(user1)
  {
    return this.http.put('http://35.232.128.150:8080/loginform1/userlogin', user1).pipe(map(res=>res));  
  }
  logou()
  {
    return this.http.get('http://35.232.128.150:8080/loginform1/signup').pipe(map(res=>res));
  }
  forgemail(u)
  {
    return this.http.post('http://localhost:8080/loginform1/forgot', u).pipe(map(res=>res));  
  }
}
