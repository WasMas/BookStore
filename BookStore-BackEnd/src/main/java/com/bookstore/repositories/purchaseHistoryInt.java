package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.models.purchaseHistory;
import com.bookstore.repositories.projection.purchaseItemInt;

public interface purchaseHistoryInt extends JpaRepository<purchaseHistory, Long> {
        @Query(value = """
                        SELECT b.title as title, ph.price as price, ph.purchase_time as purchaseTime \
                        FROM purchase_history ph JOIN book b ON ph.id_purchase = b.id_book  WHERE ph.id_user = :userId\
                        """, nativeQuery = true)
        List<purchaseItemInt> findAllPurchasesOfUser(@Param("userId") Long userId);
}
