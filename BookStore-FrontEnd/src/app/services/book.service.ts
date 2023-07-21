import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { RequestBaseService } from './request-base.service';
import { AuthenticationService } from './authentication.service';
import { HttpClient } from '@angular/common/http';
import { Book } from '../models/book.model';
import { Observable } from 'rxjs';

const API_URL = `${environment.BASE_URL}/api/book`;

@Injectable({
  providedIn: 'root',
})
export class BookService extends RequestBaseService {
  constructor(
    authenticationService: AuthenticationService,
    httpclient: HttpClient
  ) {
    super(authenticationService, httpclient);
  }

  saveBook(book: Book): Observable<any> {
    return this.httpClient.post(API_URL, book, { headers: this.headers });
  }
  deleteBook(book: Book): Observable<any> {
    return this.httpClient.delete(API_URL + '/' + book.id_book, {
      headers: this.headers,
    });
  }
  getAllbooks(): Observable<any> {
    return this.httpClient.get(API_URL);
  }
}
