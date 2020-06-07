import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {GroupPayload} from '../../payloads/group-payload';
import {Observable} from 'rxjs';
import {LocalStorageService} from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class GroupService {
  private url = 'https://localhost:7070/api/v1/group';

  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService) {
  }

  addGroup(groupPayload: GroupPayload): Observable<any> {
    return this.httpClient.post(this.url, groupPayload);
  }

  getAllGroups(): Observable<Array<GroupPayload>> {
    return this.httpClient.get<Array<GroupPayload>>(this.url);
  }

  getGroup(permaLink: number): Observable<GroupPayload> {
    return this.httpClient.get<GroupPayload>(this.url + '/' + permaLink);
  }

  deleteGroup(permaLink: number): Observable<any> {
    return this.httpClient.delete(this.url + '/' + permaLink);
  }

  updateGroup(groupPayload: GroupPayload): Observable<any> {
    return this.httpClient.put(this.url, groupPayload);
  }
}
