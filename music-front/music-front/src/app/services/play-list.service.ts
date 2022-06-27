import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/playlist/';

@Injectable({
  providedIn: 'root'
})
export class PlayListService {

  constructor(private http: HttpClient) { }

  getPlaylist(userId: number): Observable<any> {
    return this.http.get(API_URL + userId);   
  }

  getUsersPlay(userId: number): Observable<any> {
    return this.http.get(API_URL + 'getUsersPlay/' + userId);   
  }

  getUsersAll(): Observable<any> {
    return this.http.get(API_URL + 'all');   
  }

  getAlfa(userId: number, name: string, howLong: number): Observable<any> {
    return this.http.get(API_URL + 'createPlayListAlfa/' + userId +'/'+ name +'/' + howLong);   
  }

  getBeta(userId: number, name: string, howLong: number): Observable<any> {
    return this.http.get(API_URL + 'createPlayListBeta/'+ userId +'/'+ name +'/' + howLong);   
  }

  getGama(userId: number, name: string, howLong: number): Observable<any> {
    return this.http.get(API_URL + 'createPlayListGama/'+ userId +'/'+ name +'/' + howLong);   
  }
}
