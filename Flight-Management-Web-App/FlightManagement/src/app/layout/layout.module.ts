import { CommonModule } from '@angular/common';
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router'

import { HeaderComponent } from "../shared/header/header.component";
import { SidebarComponent } from "../shared/sidebar/sidebar.component";
import { FooterComponent } from "../shared/footer/footer.component";

import { BreadCrumbComponent } from "../shared/breadcrumb/breadcrumb.component";

import { LayoutComponent } from './layout.component';
import { HttpClientModule } from '@angular/common/http';


const routes: Routes = [{
    path: 'food-admin', component: LayoutComponent,
    children: [
        { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
        { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
        { path: 'users', loadChildren: './user/user.module#UserModule' },
        { path: 'categories', loadChildren: './category/category.module#CategoryModule' },
        { path: 'foods', loadChildren: './food/food.module#FoodModule' }
    ]
},
{ path: '**', redirectTo: '/food-admin', pathMatch: 'full' }
]

@NgModule({
    declarations: [HeaderComponent, SidebarComponent, FooterComponent, BreadCrumbComponent, LayoutComponent],
    imports: [
        CommonModule,
        HttpClientModule,
        RouterModule,
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule],
    providers: [],
    bootstrap: [LayoutComponent]
})
export class LayoutModule {
} 
