import { Injectable } from '@angular/core';
import{ inuser } from './mock-user';
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
 

  getUsers(): Observable <any>
  {
  return this.http.get('http://localhost:8080/loginform/userlogin').pipe(map( res => res ));
  }
  getlog(user2): Observable <any>
  {
  return this.http.post('http://localhost:8080/loginform/userlogin', user2).pipe(map( res => res ));
  }
  adduser(user)
  {
    return this.http.post('http://localhost:8080/loginform/userlogin', user).pipe(map(res=>res));
  }
  getprofile(id)
  {
    return this.http.get('http://localhost:8080/loginform/userlogin', id).pipe(map(res=>res));
  }
  deleteuser(id2)
  {
    return this.http.delete('http://localhost:8080/loginform/userlogin/',id2).pipe(map(res=>res));  
  }
  updateuser(user1)
  {
    return this.http.put('http://localhost:8080/loginform/userlogin', user1).pipe(map(res=>res));  
  }
}
