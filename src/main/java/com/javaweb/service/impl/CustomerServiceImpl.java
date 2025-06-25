package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class CustomerServiceImpl  implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;

    @Override
    public CustomerResponse addOrUpdateCustomer(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = customerConverter.toEntity(customerRequest);
        return  customerConverter.toResponse(customerRepository.save(customerEntity));
    }

    @Override
    public void removeCustomer(Long[] customerIds) {
        customerRepository.deleteByIdIn(customerIds);
    }

    @Override
    public List<CustomerResponse> getList() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntities) {
            customerResponses.add(customerConverter.toResponse(customerEntity));
        }
        return customerResponses;
    }

    @Override
    public CustomerResponse getCustomer(Long customerId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        return customerConverter.toResponse(customer);
    }


}
