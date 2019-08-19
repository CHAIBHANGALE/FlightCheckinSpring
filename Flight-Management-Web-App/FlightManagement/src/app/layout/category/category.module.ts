import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './category.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
    { path: '', component: CategoryComponent, data: { title: 'Category' } }
];

@NgModule({
    declarations: [CategoryComponent],
    imports: [CommonModule, RouterModule, RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class CategoryModule {}