export class purchaseHistory {
  id_purchase: number | undefined;
  id_book: number | undefined;
  id_user: number | undefined;
  price: number | undefined;
  purchase_time: Date = new Date();

  constructor(id_user?: number, id_book?: number, price?: number) {
    this.id_user = id_user;
    this.id_book = id_book;
    this.price = price;
  }
}
