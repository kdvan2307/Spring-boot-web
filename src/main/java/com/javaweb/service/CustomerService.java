package com.javaweb.service;

import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface CustomerService{
    CustomerRequest addOrUpdateCustomer(CustomerRequest customerRequest);
    void removeCustomer(Long[] customerIds);;
    List<CustomerResponse> findAllCustomer(CustomerSearchRequest customerSearchRequest);
    CustomerResponse getCustomer(Long customerId);
    ResponseDTO listStaffs(Long customerId);
}
