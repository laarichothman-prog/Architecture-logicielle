package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.dto.CustomerDTO;
import com.ecommerce.monolith.customer.dto.CustomerRequest;
import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerRequest request);
    CustomerDTO updateCustomer(Long id, CustomerRequest request);
    void deleteCustomer(Long id);
    boolean customerExists(Long id);
}

