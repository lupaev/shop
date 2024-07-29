package com.evraz.shop.repository;

import com.evraz.shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    @Query("SELECT SUM(oi.quantity) FROM OrderItem oi")
    Integer sumOfQuantities();
}
