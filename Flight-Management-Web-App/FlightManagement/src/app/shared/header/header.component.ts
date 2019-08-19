import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
declare var $: any;
var body = $('body');
@Component({
    selector: 'app-header',
    templateUrl: './header.component.html'
})

export class HeaderComponent implements OnInit {
   
    public profilePicture: string = '';
    public fullName: string;

    constructor(private router: Router) { }

    ngOnInit() {
    }

    toggleSideNav() {
        body.toggleClass('sidebar-icon-only');
    }

    logout(){
        this.router.navigate(['/'])
      }


}