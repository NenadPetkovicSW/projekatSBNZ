import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlayListService } from '../services/play-list.service';
import { SongService } from '../services/song.service';
import { UserService } from '../services/user.service';
import { PlayList } from '../__classes/playlist';
import { Song } from '../__classes/song';
import { User } from '../__classes/user';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {
  id = "";
  Songs: Song[] = [];
  pl = new PlayList();
  placeId: string = "";
  user = new User();

  constructor(private service: SongService,private playService: PlayListService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    let data = localStorage.getItem("user");

    this.id = this.route.snapshot.paramMap.get('id') || "";
    if(data != null)
    {
      
      this.user = JSON.parse(data || '{}');

      this.playService.getPlaylist(Number.parseInt(this.id)).subscribe({
        next: data => {
          console.log(data);
          this.pl = data;
          this.Songs = this.pl.songs;
      },
      error: err => {
        console.log(err);
        alert("Error!");
      }
    });
    }
  }


}
