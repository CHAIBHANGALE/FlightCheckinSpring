import { Injectable } from '@angular/core';
import { IUser } from '../../../models/user';
import { Api } from '../../../core/providers/api';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: IUser[];
  constructor(private api: Api) { }

  getUsers = () => {
    return this.api.get('user');
  }
}
