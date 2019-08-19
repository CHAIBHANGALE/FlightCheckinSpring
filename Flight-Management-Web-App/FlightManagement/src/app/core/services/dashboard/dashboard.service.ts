import { Injectable } from '@angular/core';
import { IDashboard } from 'src/app/models/dashboard';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  dashboard: IDashboard;
  constructor() { }

  getDashboard = () => this.dashboard = { totalCategory: 1, totalIncomeToday: 5000, totalOrderToday: 50 }

}
