import { ICategory } from './category';

export interface IFood {
    foodID: number;
    name: string;
    price: number;
    picture: string;
    category?: ICategory;
    isActive: boolean;
}


