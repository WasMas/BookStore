export class Book {
  id: number | undefined;
  title: string = '';
  author: string = '';
  price: number = 0;
  description: string = '';
  createTime: Date = new Date();

  // "?" = can be underfined
  constructor(id?: number, title: string = '', price: number = 0) {
    this.id = id;
    this.title = title;
    this.price = price;
  }
}
