package com.bookstore.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import com.bookstore.models.purchaseHistory;
import com.bookstore.repositories.purchaseHistoryInt;
import com.bookstore.repositories.projection.purchaseItemInt;

@Service
public class purchaseHistoryService implements purchaseHistoryServiceInt {
    private final purchaseHistoryInt purchaseHistoryRepository;

    public purchaseHistoryService(purchaseHistoryInt purchaseHistory) {
        this.purchaseHistoryRepository = purchaseHistory;
    }

    @Override
    public purchaseHistory savePurchase(purchaseHistory purchase) {
        purchase.setPurchaseDate(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchase);
    }

    @Override
    public List<purchaseItemInt> findUserPurchase(Long id) {
        return purchaseHistoryRepository.findAllPurchasesOfUser(id);
    }
}
