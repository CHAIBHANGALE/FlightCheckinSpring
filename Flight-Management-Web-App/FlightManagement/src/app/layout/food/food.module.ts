import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router';
import { FoodComponent } from './food.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
    { path: '', component: FoodComponent, data: { title: 'User' } }
];

@NgModule({
    declarations: [FoodComponent],
    imports: [CommonModule, RouterModule, RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class FoodModule {}