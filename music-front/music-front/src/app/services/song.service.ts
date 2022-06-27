import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/song/';
@Injectable({
  providedIn: 'root'
})
export class SongService {

  constructor(private http: HttpClient) { }

  search(name: string, userId: number): Observable<any> {
    return this.http.get(API_URL + 'search/' + name + "/" + userId);   
  }

  getLikedSings(userId: number): Observable<any> {
    return this.http.get(API_URL + 'likedSongs/' + userId);   
  }
}
