package com.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Security.userPrincipal;
import com.bookstore.models.purchaseHistory;
import com.bookstore.services.purchaseHistoryServiceInt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/purchase-history")
public class purchaseHistoryController {
    private purchaseHistoryServiceInt purchaseHistoryService;

    public purchaseHistoryController(purchaseHistoryServiceInt purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @PostMapping // api/purchase-history
    public ResponseEntity<?> savePurchaseHistory(@RequestBody purchaseHistory purchaseHistory) {
        return new ResponseEntity<>(purchaseHistoryService.savePurchase(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping // api/purchase-history
    public ResponseEntity<?> getUserPurchases(@AuthenticationPrincipal userPrincipal userPrincipal) {
        return ResponseEntity.ok(purchaseHistoryService.findUserPurchases(userPrincipal.getId()));
    }
}
