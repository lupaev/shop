package com.evraz.shop.repository;

import com.evraz.shop.entity.PaymentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentResultRepository extends JpaRepository<PaymentResult, Long> {
}
