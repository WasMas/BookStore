package com.bookstore.services;

import java.util.List;

import com.bookstore.models.purchaseHistory;
import com.bookstore.repositories.projection.purchaseItemInt;

public interface purchaseHistoryServiceInt {
    public purchaseHistory savePurchase(purchaseHistory purchase);

    public List<purchaseItemInt> findUserPurchases(Long id);
}
