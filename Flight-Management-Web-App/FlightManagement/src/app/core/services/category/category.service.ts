import { Injectable } from '@angular/core';
import { ICategory } from 'src/app/models/category';
import { Api } from '../../../core/providers/api';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  categories: ICategory[];
  constructor(private api: Api) { }

  getCategories = () => {
    return this.api.get('category');
  }
}
