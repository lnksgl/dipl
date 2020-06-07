import {Component, OnInit, NgZone} from '@angular/core';
import {UsersService} from '../services/users/users.service';
import {Router} from '@angular/router';
import {LocalStorageService} from 'ngx-webstorage';
import {UserAveragePayload} from '../payloads/user-average-payload';
import {FormControl, FormGroup} from '@angular/forms';
import * as Tesseract from '../../js/tesseract/src/Tesseract.js';
import {ImageLike} from 'tesseract.js';

@Component({
  selector: 'app-source-user',
  templateUrl: './source-user.component.html',
  styleUrls: ['./source-user.component.css']
})
export class SourceUserComponent implements OnInit {

  userForm: FormGroup;
  user: UserAveragePayload;

  constructor(private userService: UsersService, private router: Router, private localStorageService: LocalStorageService) {
  }

  ngOnInit() {
    this.userService.getCurrentUsername(this.localStorageService.retrieve('username')).subscribe((data: UserAveragePayload) => {
      this.user = data;
    }, (error: any) => {
      console.log('Failure Response');
    });
    this.userForm = new FormGroup({
      username: new FormControl(),
      email: new FormControl(),
      city: new FormControl(),
      average: new FormControl()
    });
  }

  onFileChanged(file: ImageLike) {
    Tesseract.recognize(
      file,
      'rus'
    ).then(({data: {text}}) => {
      console.log(text);

      this.user.average = text;
      this.userService.updateUser(this.user).subscribe(data => {
        this.router.navigateByUrl('v1/user');
      }, error => {
        console.log('Failure Response');
      });
    });
  }
}
