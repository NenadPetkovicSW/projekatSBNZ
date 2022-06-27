import { Component, OnInit } from '@angular/core';
import { User } from '../__classes/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user = new User();

  constructor() { }

  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
    }
  }

}
