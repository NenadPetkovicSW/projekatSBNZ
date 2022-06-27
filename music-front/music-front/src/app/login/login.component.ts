import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../__classes/user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };

  user = new User();
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string = '';
  constructor(private userService: UserService) {
   }
  ngOnInit(): void {
    let data = localStorage.getItem("user");
    
    if(data != null)
    {
      this.user = JSON.parse(data || '{}');
      this.isLoggedIn = true;
      this.roles = this.user.type;
    }
  }
  onSubmit(): void {
    const { username, password } = this.form;
    this.userService.login(username, password).subscribe({
      next: data => {
        console.log(data);
        this.user = data;
        localStorage.setItem("user", JSON.stringify(this.user));
        this.isLoginFailed = false;
        this.roles = this.user.type;
        this.isLoggedIn = true;
        window.location.reload();
    },
    error: err => {
      alert("error");
      this.errorMessage = err.error?.["message"];
      this.isLoginFailed = true;
    }
  });
  }
  reloadPage(): void {
    window.location.reload();
  }
}