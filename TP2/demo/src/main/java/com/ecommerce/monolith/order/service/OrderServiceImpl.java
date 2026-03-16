package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.customer.service.CustomerService;
import com.ecommerce.monolith.order.dto.OrderDTO;
import com.ecommerce.monolith.order.dto.OrderRequest;
import com.ecommerce.monolith.order.mapper.OrderMapper;
import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.model.Order.OrderStatus;
import com.ecommerce.monolith.order.repository.OrderRepository;
import com.ecommerce.monolith.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerService customerService;
    private final ProductService productService;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDTO getOrderById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Order not found with id: " + id));
        return mapper.toDTO(order);
    }

    @Override
    public OrderDTO createOrder(OrderRequest request) {
        if (!customerService.customerExists(request.getCustomerId())) {
            throw new IllegalArgumentException(
                    "Customer not found with id: " + request.getCustomerId());
        }
        productService.getProductById(request.getProductId());
        Order order = mapper.toEntity(request);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        return mapper.toDTO(repository.save(order));
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Order not found with id: " + id));
        order.setStatus(OrderStatus.CANCELLED);
        repository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getOrdersByCustomer(Long customerId) {
        if (!customerService.customerExists(customerId)) {
            throw new IllegalArgumentException(
                    "Customer not found with id: " + customerId);
        }
        return mapper.toDTOList(repository.findByCustomerId(customerId));
    }
}

