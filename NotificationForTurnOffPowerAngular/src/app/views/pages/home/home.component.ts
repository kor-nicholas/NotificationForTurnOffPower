import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  slides: any[] = new Array(3).fill({id: -1, src: '', title: '', subtitle: ''});

  constructor() { }

  ngOnInit(): void {
    this.slides[0] = {
      id: 0,
      src: './assets/img/home/1.jpg',
      title: 'Планові вимкнення світла у Нікопольському регіоні',
    };
    this.slides[1] = {
      id: 1,
      src: './assets/img/home/2.jpg',
      title: 'Відключення світла у Києві. Екстренні вимкнення світла у Києві',
    }
    this.slides[2] = {
      id: 2,
      src: './assets/img/home/3.jpg',
      title: 'Вимкнення світла на Франківщині сьогодні почнеться о 15 годині',
    }
  }

}
