package com.ecommerce.monolith.order.dto;

import com.ecommerce.monolith.order.model.Order.OrderStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private LocalDateTime orderDate;
    private OrderStatus status;
}

