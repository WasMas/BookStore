import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { HttpClient } from '@angular/common/http';
import { RequestBaseService } from './request-base.service';
import { purchaseHistory } from '../models/purchaseHistory.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

const API_URL = `${environment.BASE_URL}/api/purchase-history`;

@Injectable({
  providedIn: 'root',
})
export class PurchaseService extends RequestBaseService {
  constructor(
    authenticationService: AuthenticationService,
    httpClient: HttpClient
  ) {
    super(authenticationService, httpClient);
  }

  savePurchase(purchase: purchaseHistory): Observable<any> {
    return this.httpClient.post(API_URL, purchase, { headers: this.headers });
  }

  getAllPurchaseItems(): Observable<any> {
    return this.httpClient.get(API_URL, { headers: this.headers });
  }
}
