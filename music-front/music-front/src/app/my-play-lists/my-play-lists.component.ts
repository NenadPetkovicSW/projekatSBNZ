import { Component, OnInit } from '@angular/core';
import { PlayListService } from '../services/play-list.service';
import { PlayList } from '../__classes/playlist';
import { User } from '../__classes/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-play-lists',
  templateUrl: './my-play-lists.component.html',
  styleUrls: ['./my-play-lists.component.scss']
})
export class MyPlayListsComponent implements OnInit {
  PlayLists: PlayList[] = [];
  placeId: string = "";
  user = new User();

  constructor(private service: PlayListService, private router: Router) { }

  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
    }
    this.service.getUsersPlay(this.user.id).subscribe({
      next: data => {
        console.log(data);
        this.PlayLists = data;
    },
    error: err => {
      console.log(err);
      alert("Error!");
    }
  });
  }

  btnClick (id: number){
    window.open('http://localhost:4001/playlists/'+id, "_self");
  };

}
