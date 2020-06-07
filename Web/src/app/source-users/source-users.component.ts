import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {UsersService} from '../services/users/users.service';
import {UserAveragePayload} from '../payloads/user-average-payload';

@Component({
  selector: 'app-source-users',
  templateUrl: './source-users.component.html',
  styleUrls: ['./source-users.component.css']
})
export class SourceUsersComponent implements OnInit {

  page = 1;
  user: UserAveragePayload;

  users: Observable<Array<UserAveragePayload>>;

  constructor(private userService: UsersService) {
    this.users = this.userService.getAllUsers();
    this.users.forEach(data => {
      console.log(data);
    });
  }

  ngOnInit() {
  }

  deleteUser(id) {
    this.userService.deleteUser(id).subscribe();
  }

  searchUser(value: string) {
  }
}
