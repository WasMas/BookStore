package com.bookstore.repositories.projection;

import java.time.LocalDateTime;

public interface purchaseItemInt {
    String getTitle();

    double getPrice();

    LocalDateTime getPurchaseTime();
}
