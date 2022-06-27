import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import { User } from '../__classes/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  age = 15;
  profileForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    first_name: new FormControl(''),
    age: new FormControl,
    last_name: new FormControl(''),
  });

  user = new User();
  
  constructor(private service: UserService) { }

  ngOnInit(): void {
  }
  addUser(){
    let formObj = this.profileForm.getRawValue();
    if(formObj.username == "" || formObj.password == "" || formObj.firstName == "" || formObj.lastName == "" )
    {
      alert("POPUNI SVA POLJA!");
    }
    else{

      this.user = formObj;
      this.user.age = this.age;
      this.user.ageGroup = this.ageing(this.age);

    this.service.register(this.user).subscribe({
      next: data => {
        console.log(data);
        alert("Registered!");
    },
    error: err => {
      console.log(err);
      alert("Error!");
    }
  });
  }
  }
  public onChnage()
  {
    this.age = Number.parseInt((<HTMLInputElement>document.getElementById("age")).value);
  }
  public ageing(age: number)
  {
    if(age < 20)
      return "TEEN";
    else if(19 < age && age < 40)
      return "YOUNG_ADULT";
    else if(39 < age && age < 65)
      return "ADULT";
    else
      return "ELDER";
  }
}
