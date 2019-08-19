import { NgModule } from "@angular/core";
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
    { path: '', component: UserComponent, data: { title: 'User' } }
];

@NgModule({
    declarations: [UserComponent],
    imports: [CommonModule, RouterModule, RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class UserModule {}