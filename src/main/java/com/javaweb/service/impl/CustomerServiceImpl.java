package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class CustomerServiceImpl  implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerConverter customerConverter;

    private final UserRepository userRepository;

    @Override
    public CustomerRequest addOrUpdateCustomer(CustomerRequest customerRequest) {
        CustomerEntity customerEntity = customerConverter.toEntity(customerRequest);
        return  customerConverter.toCustomerRequest(customerRepository.save(customerEntity));
    }

    @Override
    public void removeCustomer(Long[] customerIds) {
        customerRepository.deleteByIdIn(customerIds);
    }

    @Override
    public List<CustomerResponse> findAllCustomer(CustomerSearchRequest customerSearchRequest) {

        List<CustomerEntity> customerEntities = customerRepository.findAll(customerSearchRequest);
        List <CustomerResponse> result = new ArrayList<CustomerResponse>();
        for (CustomerEntity item : customerEntities) {
            CustomerResponse customerResponse = customerConverter.toResponse(item);
            result.add(customerResponse);
        }
        return result;
    }

    @Override
    public CustomerResponse getCustomer(Long customerId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        return customerConverter.toResponse(customer);
    }

    @Override
    public ResponseDTO listStaffs(Long customerId) {
        CustomerEntity customer = customerRepository.findById(customerId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<UserEntity> staffAssignment = customer.getUsersEntities();
        List<StaffResponseDTO>  staffResponseDTOs = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (UserEntity it : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if(staffAssignment.contains(it)){
                staffResponseDTO.setChecked("checked");
            }
            else{
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOs.add(staffResponseDTO);
        }
        responseDTO.setData((staffResponseDTOs));
        responseDTO.setMessage("success");
        return responseDTO;
    }


}
