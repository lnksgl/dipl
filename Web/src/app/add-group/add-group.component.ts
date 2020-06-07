import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, NgModel} from '@angular/forms';
import {GroupPayload} from '../payloads/group-payload';
import {GroupService} from '../services/group/group.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css']
})
export class AddGroupComponent implements OnInit {

  addPostForm: FormGroup;
  groupPayload: GroupPayload;
  name = new FormControl('');
  content = new FormControl('');

  constructor(private groupService: GroupService, private router: Router) {
    this.addPostForm = new FormGroup({
      name: this.name,
      content: this.content
    });
    this.groupPayload = {
      id: '',
      name: '',
      content: '',
      average: ''
    };
  }

  ngOnInit() {
  }

  addPost(name: string, content: string) {
    this.groupPayload.name = name;
    this.groupPayload.content = content;
    this.groupService.addGroup(this.groupPayload).subscribe(data => {
      this.router.navigateByUrl('');
    }, error => {
      console.log('Failure Response');
    });
  }
}
