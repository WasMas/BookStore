package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.models.purchaseHistory;
import com.bookstore.repositories.projection.purchaseItemInt;

public interface purchaseHistoryInt extends JpaRepository<purchaseHistory, Long> {
    @Query("SELECT b.title as bookTitle ph.price as Price, ph.purchaseDate FROM purchaseHistory ph JOIN books b" +
            " ON ph.id_purchase = b.id_book WHERE ph.id_user = :userId ")
    List<purchaseItemInt> findAllPurchasesOfUser(@Param("userId") long userId);
}
