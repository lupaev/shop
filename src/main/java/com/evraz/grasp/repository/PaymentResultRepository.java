package com.evraz.grasp.repository;

import com.evraz.grasp.entity.PaymentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentResultRepository extends JpaRepository<PaymentResult, Long> {
}
