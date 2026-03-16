package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.dto.OrderDTO;
import com.ecommerce.monolith.order.dto.OrderRequest;
import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    OrderDTO createOrder(OrderRequest request);
    void cancelOrder(Long id);
    List<OrderDTO> getOrdersByCustomer(Long customerId);
}

