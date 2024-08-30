package com.github.lupaev.shop.repository;

import com.github.lupaev.shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    @Query("SELECT SUM(oi.quantity) FROM OrderItem oi")
    Integer sumOfQuantities();
}
