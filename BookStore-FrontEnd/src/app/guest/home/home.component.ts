import { Component, OnInit } from '@angular/core';
import { faBook } from '@fortawesome/free-solid-svg-icons';
import { Book } from 'src/app/models/book.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BookService } from 'src/app/services/book.service';
import { PurchaseHistoryService } from 'src/app/services/purchase-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  bookList: Array<Book> = [];
  faBook = faBook;
  errorMessage: String = '';
  infoMessage: String = '';
  constructor(
    private authenticationService: AuthenticationService,
    private bookService: BookService,
    private purchaseHistoryService: PurchaseHistoryService
  ) {}
  ngOnInit(): void {
    this.bookService.getAllbooks().subscribe((data) => {
      this.bookList = data;
    });
  }
  
  purchase(item: Book){
    if(this.authenticationService.currentUserValue?.id_user){
      this.errorMessage = 'You should log in';
      return;
    }
    const purchase = new purch
  }
}
