import { Component } from '@angular/core';
import { User } from './__classes/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  isLoggedIn = false;
  showAdminBoard = false;
  showRegularBoard = false;
  username?: string;
  title: any;
  user = new User();
  roles : string= "";

  constructor() { }
  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
      this.isLoggedIn = true;
      this.roles = this.user.type;
      this.showAdminBoard = this.roles == ('ADMIN');
      this.showRegularBoard = this.roles == ('REGULAR');
      this.username = this.user.username;
    }  

  }

  logout(): void {
    localStorage.clear();
    window.location.reload();
  }

}
