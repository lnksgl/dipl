import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {GroupService} from '../services/group/group.service';
import {GroupPayload} from '../payloads/group-payload';

@Component({
  selector: 'app-post',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {

  post: GroupPayload;
  permaLink: number;

  constructor(private router: ActivatedRoute, private groupService: GroupService) {
  }

  ngOnInit() {
    this.router.params.subscribe(params => {
      this.permaLink = params.id;
    });

    this.groupService.getGroup(this.permaLink).subscribe((data: GroupPayload) => {
      this.post = data;
    }, (error: any) => {
      console.log('Failure Response');
    });
  }

  deletePost(id) {
    this.groupService.deleteGroup(id).subscribe();
  }
}
