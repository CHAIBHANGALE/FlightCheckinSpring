import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/core/services/category/category.service';
import { ICategory } from 'src/app/models/category';
import { ResponseWrapper } from 'src/app/core/providers/ResponseWrapper';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  categories: ICategory[];
  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.categoryService.getCategories().subscribe((response: ResponseWrapper) => {
      this.categories = response.data as ICategory[];
      console.log(this.categories);
    },
    error => {
      console.log(error);
    })
  }

}
