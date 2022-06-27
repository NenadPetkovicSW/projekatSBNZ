import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../__classes/user';

const API_URL = 'http://localhost:8080/api/user/';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.get(API_URL + 'login/' + username + "/" + password);   
  }

  likeSong(userId: number, songId: number): Observable<any> {

    return this.http.put(API_URL + 'like/' + userId + "/" + songId,[]);   
  }

  register(user: User): Observable<any> {
    console.log(user)
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    return this.http.post(API_URL + 'register', user,{headers: headers});
  }

  
}
