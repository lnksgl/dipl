import {Component, OnInit} from '@angular/core';
import {GroupService} from '../services/group/group.service';
import {Observable} from 'rxjs';
import {GroupPayload} from '../payloads/group-payload';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  page: number = 1;
  post: GroupPayload;

  posts: Observable<Array<GroupPayload>>;

  constructor(private groupService: GroupService) {
  }

  ngOnInit() {
  }
}
