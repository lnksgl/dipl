import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {EnquiryPayload} from '../../payloads/enquiry-payload';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnquiryService {
  private url = 'https://localhost:7070/api/v1/enquiry';

  constructor(private httpClient: HttpClient) {}

  createEnquiry(enquiry: EnquiryPayload): Observable<any> {
    return this.httpClient.post(this.url, enquiry);
  }

  deleteEnquiry(permaLink: number): Observable<any> {
    return this.httpClient.delete(this.url + '/' + permaLink);
  }
}
