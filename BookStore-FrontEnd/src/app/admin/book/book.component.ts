import { Component } from '@angular/core';
import { Book } from 'src/app/models/book.model';
import { BookService } from 'src/app/services/book.service';

declare var $: any;

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent {
  book: Book = new Book();
  errorMessage: String = '';
  constructor(private bookService: BookService) {}

  saveBook() {
    this.bookService.saveBook(this.book).subscribe(
      (data) => {
        // ..
      },
      (err) => {
        this.errorMessage = 'IDK WHAT HAPPENED SUE ME';
        console.log(err);
      }
    );
  }

  showBookModal() {
    $('#bookmodal').modal('show');
  }
}
