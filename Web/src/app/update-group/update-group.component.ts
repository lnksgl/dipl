import { Component, OnInit } from '@angular/core';
import {GroupPayload} from "../payloads/group-payload";
import {ActivatedRoute, Router} from "@angular/router";
import {GroupService} from '../services/group/group.service';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-update-post',
  templateUrl: './update-group.component.html',
  styleUrls: ['./update-group.component.css']
})
export class UpdateGroupComponent implements OnInit {

  updateGroupForm: FormGroup;
  permaLink: number;
  group: GroupPayload;
  name = new FormControl('');
  content = new FormControl('');

  constructor(private activatedRoute: ActivatedRoute, private groupService: GroupService, private router: Router) {
    this.updateGroupForm = new FormGroup({
      name: this.name,
      content: this.content
    });
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.permaLink = params.id;
    });

    this.groupService.getGroup(this.permaLink).subscribe((data: GroupPayload) => {
      this.group = data;
      this.updateGroupForm.get('content').setValue(this.group.content);
    }, (error: any) => {
      console.log('Failure Response');
    });
  }

  updatePost(name: string, content: string) {
    this.group.content = content;
    this.group.name = name;
    this.groupService.updateGroup(this.group).subscribe(data => {
      this.router.navigateByUrl('/');
    }, error => {
      console.log('Failure Response');
    });
  }

  assertValidate(title: string, category: string, body: string) {
    return !(title != '' && category != '' && body != '');
  }

  deletePost(id) {
    this.groupService.deleteGroup(id).subscribe();
  }
}
