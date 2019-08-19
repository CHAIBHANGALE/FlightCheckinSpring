import { Component, OnInit } from '@angular/core';
import { UserService } from '../../core/services/user/user.service'
import { IUser } from 'src/app/models/user';
import { ResponseWrapper } from 'src/app/core/providers/ResponseWrapper';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  users: IUser[];
  user: any;
  constructor(private userService: UserService) { }

  ngOnInit() {
    return this.userService.getUsers().subscribe((response: ResponseWrapper) => {
        this.users = response.data as IUser[];
    }, error => { 

    });
  }

}
