package com.github.lupaev.shop.repository;

import com.github.lupaev.shop.entity.PaymentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentResultRepository extends JpaRepository<PaymentResult, Long> {
}
