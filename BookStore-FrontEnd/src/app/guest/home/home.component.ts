import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faBook } from '@fortawesome/free-solid-svg-icons';
import { Book } from 'src/app/models/book.model';
import { purchaseHistory } from 'src/app/models/purchaseHistory.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { BookService } from 'src/app/services/book.service';
import { PurchaseService } from 'src/app/services/purchase.service';

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
    private purchaseService: PurchaseService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.bookService.getAllbooks().subscribe((data) => {
      this.bookList = data;
    });
  }

  purchase(item: Book) {
    if (!this.authenticationService.currentUserValue?.id_user) {
      this.errorMessage = 'You should log in';
      setTimeout(() => {
        this.router.navigate(['/profile']);
      }, 2000);
      return;
    }
    const purchase = new purchaseHistory(
      this.authenticationService.currentUserValue.id_user,
      item.id_book,
      item.price
    );
    this.purchaseService.savePurchase(purchase).subscribe(
      (data) => {
        this.infoMessage = 'Operation Completed Succefully';
      },
      (err) => {
        this.errorMessage = 'IDK WHAT HAPPENED SUE ME';
        console.log(err);
      }
    );
  }
}
