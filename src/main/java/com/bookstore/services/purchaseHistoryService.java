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

    public purchaseHistoryService(purchaseHistoryInt purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public purchaseHistory savePurchase(purchaseHistory purchase) {
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchase);
    }

    @Override
    public List<purchaseItemInt> findUserPurchase(Long userId) {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}