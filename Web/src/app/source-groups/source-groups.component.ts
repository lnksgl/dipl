import {Component, OnInit} from '@angular/core';
import {GroupPayload} from '../payloads/group-payload';
import {Observable} from 'rxjs';
import {GroupService} from '../services/group/group.service';
import {EnquiryPayload} from '../payloads/enquiry-payload';
import {LocalStorageService} from 'ngx-webstorage';
import {Router} from '@angular/router';
import {EnquiryService} from '../services/enquiry/enquiry.service';
import {AuthService} from '../services/auth/auth.service';

@Component({
  selector: 'app-source-posts',
  templateUrl: './source-groups.component.html',
  styleUrls: ['./source-groups.component.css']
})
export class SourceGroupsComponent implements OnInit {

  page = 1;
  group: GroupPayload;
  enquiry: EnquiryPayload;

  groups: Observable<Array<GroupPayload>>;

  constructor(private groupService: GroupService, private enquiryService: EnquiryService,
              private localStorageService: LocalStorageService,
              private router: Router,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.groups = this.groupService.getAllGroups();
    this.enquiry = {
      username: this.localStorageService.retrieve('username'),
      name: ''
    };
  }

  create(name: string) {
    this.enquiry.name = name; 
    this.enquiryService.createEnquiry(this.enquiry);
  }
}
