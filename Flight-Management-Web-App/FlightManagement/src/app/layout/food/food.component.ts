import { Component, OnInit } from '@angular/core';
import { FoodService } from 'src/app/core/services/food/food.service';
import { IFood } from 'src/app/models/food';
import { ResponseWrapper } from 'src/app/core/providers/ResponseWrapper';

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.scss']
})
export class FoodComponent implements OnInit {

  foods: IFood[];
  constructor(private foodService: FoodService) { }

  ngOnInit() {
    return this.foodService.getFoods().subscribe((response: ResponseWrapper) => {
      this.foods = response.data as IFood[];
    }, error => {
      console.log(error);
    })
  }

}
