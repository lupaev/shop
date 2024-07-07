package com.evraz.grasp.specification;

import com.evraz.grasp.entity.OrderItem;
import org.springframework.data.jpa.domain.Specification;

public class OrderItemSpecification {

    public static Specification<OrderItem> hasMinimumQuantity(Integer minQuantity) {
        return (root, query, cb) -> {
            if (minQuantity == null) {
                return cb.isTrue(cb.literal(true));
            }
            return cb.greaterThanOrEqualTo(root.get("quantity"), minQuantity);
        };
    }
}
