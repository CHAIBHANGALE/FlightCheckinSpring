import { Component } from "@angular/core";
import { Router } from '@angular/router';

@Component({
    selector: 'app-breadcrumb',
    templateUrl: './breadcrumb.component.html'
})

export class BreadCrumbComponent {

    public profilePicture: string = '';
    public fullName: string;

    constructor() {
       
    }

   
}