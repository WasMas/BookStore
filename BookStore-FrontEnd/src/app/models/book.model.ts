export class Book {
  id_book: number | undefined;
  title: string = '';
  author: string = '';
  price: number = 0;
  description: string = '';
  createTime: Date = new Date();

  // "?" = can be underfined
  constructor(id?: number, title: string = '', price: number = 0) {
    this.id_book = id;
    this.title = title;
    this.price = price;
  }
}
