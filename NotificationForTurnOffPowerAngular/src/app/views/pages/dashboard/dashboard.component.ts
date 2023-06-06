import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup } from '@angular/forms';

import { DashboardChartsData, IChartProps } from './dashboard-charts-data';

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
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  constructor(private chartsData: DashboardChartsData) {
  }

  isSetTelegramId: boolean = false;
  isShowInstruction: boolean = false;

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

  ngOnInit(): void {
    fetch('http://localhost:8080/users/getById/' + localStorage.getItem('id'), {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
    .then((responce) => { return responce.json(); })
    .then((data) => {
      this.user.id = data['id'],
      this.user.name = data['name'],
      this.user.surname = data['surname'],
      this.user.telegramId = data['telegramid'] === null ? 0 : data['telegramid'],
      this.user.dateOfBirthday = data['dateofbirthday'],
      this.user.age = data['age'],
      this.user.city = data['city'],
      this.user.login = data['login'],
      this.user.pass = data['pass'],

      this.isSetTelegramId = this.user.telegramId ? true : false;
    })
    .catch((error) => {
      console.log(error);
    })
  }

  toggleCollapse(): void {
    this.isShowInstruction = !this.isShowInstruction;
  }

  inputName(event: any) {
    this.user.name = event.target.value;
  }

  inputSurname(event: any) {
    this.user.surname = event.target.value;
  }

  inputDateOfBirthday(event: any) {
    this.user.dateOfBirthday = event.target.value;
  }

  inputCity(event: any) {
    this.user.city = event.target.value;
  }

  changeUser(): void {
    fetch('http://localhost:8080/users/changeUserById', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        id: this.user.id,
        name: this.user.name,
        surname: this.user.surname,
        telegramid: this.user.telegramId,
        dateofbirthday: this.user.dateOfBirthday,
        city: this.user.city,
      })
    })
    .then((responce) => {
      if(responce['status'] === 200) {
        alert('Your account changed');
        window.location.reload();
      }
      else {
        throw Error(responce.toString());
      }
    })
    .catch((error) => {
      console.log(error);
      alert('Виникла якась проблема. Можливо ви не зареєстровані або це технічні проблеми з нашої сторони ');
    })
  }

  inputTelegramId(event: any) {
    this.user.telegramId = event.target.value;
  }

  setTelegramId(): void {
    fetch('http://localhost:8080/users/changeTelegramIdById/' + this.user.id + '/' + this.user.telegramId, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then((responce) => {
      if(responce['status'] === 200) {
        alert('Your Telegram Id changed');
        window.location.reload();
      }
      else {
        throw Error(responce.toString());
      }
    })
    .catch((error) => {
      console.log(error);
      alert('Виникла якась проблема. Можливо ви не зареєстровані або це технічні проблеми з нашої сторони');
    });
  }

  deleteAccount(): void {
    let deleteBool = confirm("Are you agree ?");
    if(deleteBool) {
      fetch('http://localhost:8080/users/deleteById/' + this.user.id, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((responce) => {
        if(responce['status'] === 200) {
          localStorage.removeItem('id');
          this.user.id = 0;
          this.user.name = '';
          this.user.surname = '';
          this.user.telegramId = 0;
          this.user.dateOfBirthday = '';
          this.user.age = 0;
          this.user.city = '';
          this.user.login = '';
          this.user.pass = '';
          alert('Your account deleted');
          window.open('http://localhost:4200/#/login', '_self');
        }
        else {
          throw Error(responce.toString());
        }
      })
      .catch((error) => {
        console.log(error);
        alert('Виникла якась проблема. Можливо ви не зареєстровані або це технічна проблема з нашої сторони');
      })
    };
  }
}
