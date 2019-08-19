import { Component, OnInit } from '@angular/core';
import { DashboardService } from 'src/app/core/services/dashboard/dashboard.service';
import { IDashboard } from 'src/app/models/dashboard';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  dashboard: IDashboard;
  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.dashboard = this.dashboardService.getDashboard();
  }

}
