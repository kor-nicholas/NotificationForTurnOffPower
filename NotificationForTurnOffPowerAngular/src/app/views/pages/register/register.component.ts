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
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  constructor() { }



  repeatPass: string = '';

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

  inputName(event: any): void {
    this.user.name = event.target.value;
  }

  inputSurname(event: any): void {
    this.user.surname = event.target.value;
  }

  inputDateOfBirthday(event: any): void {
    this.user.dateOfBirthday = event.target.value;
  }

  inputCity(event: any): void {
    this.user.city = event.target.value;
  }

  inputLogin(event: any): void {
    this.user.login = event.target.value;
  }

  inputPass(event: any): void {
    this.user.pass = event.target.value;
  }

  inputRepeatPass(event: any): void {
    this.repeatPass = event.target.value;
  }

  register(): void {
    if(this.repeatPass !== this.user.pass) {
      alert('Пароль та Повторний пароль не співпадають');
    }
    else {
      fetch('http://localhost:8080/users/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          name: this.user.name,
          surname: this.user.surname,
          dateofbirthday: this.user.dateOfBirthday,
          city: this.user.city,
          login: this.user.login,
          pass: this.user.pass,
        })
      })
      .then((responce) => { return responce.json() })
      .then((data) => {
        localStorage.setItem('id', data['id']);
        window.open('http://localhost:4200/#/dashboard', '_self');
      })
      .catch((error) => {
        console.log(error);
        alert('Сталася помилка при реєстрації вашого облікового запису. Спробуйте пізніше')
      });
    }
  }

}
