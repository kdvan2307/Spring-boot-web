package com.javaweb.service;

import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService{
    CustomerResponse addOrUpdateCustomer(CustomerRequest customerRequest);
    void removeCustomer(Long[] customerIds);
    List<CustomerResponse> getList();
    CustomerResponse getCustomer(Long customerId);
}
