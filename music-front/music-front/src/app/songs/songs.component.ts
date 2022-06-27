import { Component, OnInit } from '@angular/core';
import { SongService } from '../services/song.service';
import { UserService } from '../services/user.service';
import { Song } from '../__classes/song';
import { User } from '../__classes/user';

@Component({
  selector: 'app-songs',
  templateUrl: './songs.component.html',
  styleUrls: ['./songs.component.scss']
})
export class SongsComponent implements OnInit {
  Songs: Song[] = [];
  placeId: string = "";
  user = new User();

  constructor(private service: SongService,private userService: UserService) { }

  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
    }
  }

  onClickDelete($event:any, id: number): void
  {
    console.log($event.target.id)
    this.userService.likeSong(this.user.id, id).subscribe({
      next: data => {
        console.log(data);
        alert("Liked")
        window.location.reload();
    },
    error: err => {
      console.log(err);
      alert("Error!");
    }
  });

  }

  onClickSearch(): void
  {

    let id = ((document.getElementById("barSearch") as HTMLInputElement).value);
    if(id=="")
    {
      this.Songs = [];
    }
    else
    {
    this.service.search(id, this.user.id).subscribe({
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
