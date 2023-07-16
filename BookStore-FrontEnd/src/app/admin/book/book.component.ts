import { Component, EventEmitter, Output } from '@angular/core';
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
  @Output() save = new EventEmitter<any>();
  constructor(private bookService: BookService) {}

  saveBook() {
    this.bookService.saveBook(this.book).subscribe(
      (data) => {
        this.save.emit(data);
        $('#bookModal').modal('hide');
      },
      (err) => {
        this.errorMessage = 'IDK WHAT HAPPENED SUE ME';
        console.log(err);
      }
    );
  }

  showBookModal() {
    $('#bookModal').modal('show');
  }
}
