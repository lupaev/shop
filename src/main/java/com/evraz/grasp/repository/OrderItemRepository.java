package com.evraz.grasp.repository;

import com.evraz.grasp.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, JpaSpecificationExecutor<OrderItem> {
    @Query("SELECT SUM(oi.quantity) FROM OrderItem oi")
    Integer sumOfQuantities();
}
