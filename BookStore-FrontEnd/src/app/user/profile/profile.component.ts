import { Component, OnInit } from '@angular/core';
import { purchaseItem } from 'src/app/models/purchaseItem.model';
import { PurchaseService } from 'src/app/services/purchase.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  purchaseItemList: Array<purchaseItem> = [];

  constructor(private purchaseService: PurchaseService) {}

  ngOnInit(): void {
    this.purchaseService.getAllPurchaseItems().subscribe((data) => {
      this.purchaseItemList = data;
    });
  }
}
