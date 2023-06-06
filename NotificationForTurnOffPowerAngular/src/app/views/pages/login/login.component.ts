import { Component } from '@angular/core';

interface IUser {
  id: number,
  name: string,
  surname: string,
  telegramId: number,
  dateOfBirthday: string,
  age: number,
  city: string,
  login: string,
  pass: string,
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor() { }

  user: IUser = {
    id: 0,
    name: '',
    surname: '',
    telegramId: 0,
    dateOfBirthday: '',
    age: 0,
    city: '',
    login: '',
    pass: '',
  }

  login(): void {
    fetch('http://localhost:8080/users/login/' + this.user.login + '/' + this.user.pass, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(responce => { return responce.json(); })
    .then((data) => {
      console.log(data);
      localStorage.setItem('id', data['id']);
      window.open('http://localhost:4200/#/dashboard', '_self');
     })
    .catch((error) => {
      console.log(error);
      alert('Виникла проблема при вході до вашого облікового запису. Можливо ви не зареєструвались або ми маємо технічні неполадки');
    });
  }

  onChangeLogin(event: any) {
    this.user.login = event.target.value;
  }

  onChangePass(event: any) {
    this.user.pass = event.target.value;
  }

}
