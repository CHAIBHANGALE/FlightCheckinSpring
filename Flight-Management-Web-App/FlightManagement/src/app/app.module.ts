import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { Api } from './core/providers/api';
import { BaseUrlProvider } from './core/providers/base.url.provider';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { Routes, RouterModule } from '@angular/router';
import { AuthModule } from './auth/auth.module';


const routes: Routes = [
  { path: '', loadChildren: "./layout/layout.module#LayoutModule" },
  { path: 'auth', loadChildren: "./auth/auth.module#AuthModule" }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    AuthModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
   
  ],
  providers: [BaseUrlProvider, Api],
  bootstrap: [AppComponent]
})
export class AppModule { }
