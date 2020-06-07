import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {RegisterPayload} from '../../payloads/register-payload';
import {AuthService} from '../../services/auth/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  registerPayload: RegisterPayload;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
    this.registerForm = this.formBuilder.group({
      username: '',
      email: '',
      password: '',
      confirmPassword: '',
      city: ''
    });
    this.registerPayload = {
      username: '',
      email: '',
      password: '',
      city: ''
    };
  }

  ngOnInit() {
  }

  onSubmit(username: string, email: string, password: string, confirmPassword: string, city: string) {
    this.registerPayload.username = username;
    this.registerPayload.email = email;
    this.registerPayload.password = password;
    this.registerPayload.city = city;

    if (this.registerPayload.password === confirmPassword) {
      this.authService.register(this.registerPayload).subscribe(data => {
          this.router.navigateByUrl('v1/login');
        }, error => {
          console.log('Error');
        }
      );
    } else {
      console.log('Error');
    }
  }

  assertValidate(username: string, email: string, password: string, confirmPassword: string, city: string) {
    return !(username != '' && email != '' && password != '' && confirmPassword != '' && city != '');
  }
}
