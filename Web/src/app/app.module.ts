import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {RegisterComponent} from './auth/register/register.component';
import {LoginComponent} from './auth/login/login.component';
import {RegisterSuccessComponent} from './auth/register-success/register-success.component';
import {HeaderComponent} from './header/header.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {Ng2Webstorage} from 'ngx-webstorage';
import {HomeComponent} from './home/home.component';
import {AddGroupComponent} from './add-group/add-group.component';
import {EditorModule} from '@tinymce/tinymce-angular';
import {HttpClientInterceptor} from './http-client-interceptor';
import {GroupComponent} from './group/group.component';
import {AuthGuard} from './auth.guard';
import {NgxPaginationModule} from 'ngx-pagination';
import {UpdateGroupComponent} from './update-group/update-group.component';
import {MatSelectModule} from '@angular/material/select';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {SourceGroupsComponent} from './source-groups/source-groups.component';
import {SourceUsersComponent} from './source-users/source-users.component';
import {SourceUserComponent} from './source-user/source-user.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    RegisterSuccessComponent,
    HeaderComponent,
    HomeComponent,
    AddGroupComponent,
    GroupComponent,
    UpdateGroupComponent,
    SourceGroupsComponent,
    SourceUsersComponent,
    SourceUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2Webstorage.forRoot(),
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'v1/register', component: RegisterComponent},
      {path: 'v1/group/:id', component: GroupComponent},
      {path: 'v1/login', component: LoginComponent},
      {path: 'v1/get/:id', component: UpdateGroupComponent},
      {path: 'v1/group', component: AddGroupComponent, canActivate: [AuthGuard]},
      {path: 'v1/groups', component: SourceGroupsComponent},
      {path: 'v1/users', component: SourceUsersComponent},
      {path: 'v1/user', component: SourceUserComponent},
    ]),
    HttpClientModule,
    EditorModule,
    NgxPaginationModule,
    MatSelectModule,
    BrowserAnimationsModule,
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
