import { Component, OnInit, ViewChild } from '@angular/core';
import { Book } from 'src/app/models/book.model';
import { BookService } from 'src/app/services/book.service';
import { BookComponent } from '../book/book.component';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  bookList: Array<Book> = [];
  selectedBook: Book = new Book();
  errorMessage: String = '';
  @ViewChild(BookComponent) child: BookComponent | undefined;
  constructor(private bookService: BookService) {}
  ngOnInit(): void {
    this.bookService.getAllbooks().subscribe((data) => (this.bookList = data));
  }
  createBookRequest() {
    this.selectedBook = new Book();
    this.child?.showBookModal();
  }

  editBookRequest(item: Book) {
    this.selectedBook = Object.assign({}, item);
    this.child?.showBookModal();
  }

  saveBookWatcher(book: Book) {
    let itemIndex = this.bookList.findIndex(
      (item) => item.id_book === book.id_book
    );
    if (itemIndex !== -1) {
      this.bookList[itemIndex] = book;
    } else {
      this.bookList.push(book);
    }
  }

  deleteBook(item: Book, ind: number) {
    this.bookService.deleteBook(item).subscribe(
      (data) => {
        this.bookList.splice(ind, 1);
      },
      (err) => {
        this.errorMessage = "Couldn't Delete, SUE ME!";
        console.log(err);
      }
    );
  }
}
