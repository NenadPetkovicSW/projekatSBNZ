import { Component, OnInit } from '@angular/core';
import { SongService } from '../services/song.service';
import { UserService } from '../services/user.service';
import { Song } from '../__classes/song';
import { User } from '../__classes/user';

@Component({
  selector: 'app-liked-songs',
  templateUrl: './liked-songs.component.html',
  styleUrls: ['./liked-songs.component.scss']
})
export class LikedSongsComponent implements OnInit {

  Songs: Song[] = [];
  placeId: string = "";
  user = new User();

  constructor(private service: SongService,private userService: UserService) { }

  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
      
      this.service.getLikedSings(this.user.id).subscribe({
        next: data => {
          console.log(data);
          this.Songs = data;
      },
      error: err => {
        console.log(err);
        alert("Error!");
      }
    });
    }
  }

}
