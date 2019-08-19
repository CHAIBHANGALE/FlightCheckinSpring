import { Injectable } from '@angular/core';
import { IFood } from 'src/app/models/food';
import { Api } from '../../../core/providers/api';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  foods: IFood[];
  constructor(private api: Api) { }

  getFoods = () => {
    return this.api.get('food');
  }
}
