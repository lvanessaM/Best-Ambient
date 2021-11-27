import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string;
  password: string;

  constructor() {}

  ngOnInit(): void {}

  login() {
    localStorage.setItem('username', this.username);
    localStorage.setItem('password', this.password);
    console.log('user: ' + this.username + ' passw: ' + this.password);
  }
}
