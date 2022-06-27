import { Component, OnInit } from '@angular/core';
import { PlayListService } from '../services/play-list.service';
import { PlayList } from '../__classes/playlist';
import { User } from '../__classes/user';

@Component({
  selector: 'app-discover',
  templateUrl: './discover.component.html',
  styleUrls: ['./discover.component.scss']
})
export class DiscoverComponent implements OnInit {
  howMuch = 10;
  name = "Play";
  playlist = new PlayList();
  user = new User();

  constructor(private service: PlayListService) { }

  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
    }

    this.howMuch = Number.parseInt((<HTMLInputElement>document.getElementById("howMuch")).value);
    this.name = (<HTMLInputElement>document.getElementById("name")).value;
  }

  public onChnage()
  {
    this.howMuch = Number.parseInt((<HTMLInputElement>document.getElementById("howMuch")).value);
  }

  public onChnageTxt()
  {
    this.name = (<HTMLInputElement>document.getElementById("name")).value;
  }

  onAlfa(): void
  {
    this.service.getAlfa(this.user.id,this.name,this.howMuch).subscribe({
      next: data => {
        console.log(data);
        alert("Created Alfa Playlist: " + this.name);
    },
    error: err => {
      console.log(err);
      alert("Error! You need to like some songs first!");
    }
  });
  }

  onBeta(): void
  {
    this.service.getBeta(this.user.id,this.name,this.howMuch).subscribe({
      next: data => {
        console.log(data);
        alert("Created Beta Playlist: " + this.name);
    },
    error: err => {
      console.log(err);
      alert("Error! You need to like some songs first!");
    }
  });
  }

}
