export class purchaseHistory {
  id_purchase: number | undefined;
  userId: number | undefined;
  bookId: number | undefined;
  price: number | undefined;
  purchase: Date = new Date();

  constructor(id?: number, bookId?: number, price?: number) {
    this.id_purchase = id;
    this.bookId = bookId;
    this.price = price;
  }
}
