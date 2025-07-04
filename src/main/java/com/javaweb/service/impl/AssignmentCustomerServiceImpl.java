package com.javaweb.service.impl;

import com.javaweb.entity.AssignmentCustomerEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.AssignmentCutomerDTO;
import com.javaweb.repository.AssignmentCustomerRepository;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.AssignmentCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AssignmentCustomerServiceImpl implements AssignmentCustomerService {

    private final AssignmentCustomerRepository assignmentCustomerRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    @Override
    public void deleteAssignmentCustomer(Long[] ids) {

//        for (Long it : ids){
//            BuildingEntity buildingEntity = buildingRepository.findById(it).get();
//            assignmentBuildingRepository.deleteByAssignment(buildingEntity);
//        }
        assignmentCustomerRepository.deleteByAssignment_IdIn(ids);
    }

    @Override
    public void addAssignmentCustomerEntity(AssignmentCutomerDTO assignmentCutomerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(assignmentCutomerDTO.getCustomerId()).get();
        assignmentCustomerRepository.deleteByAssignment(customerEntity);
        List<Long> staffs = assignmentCutomerDTO.getStaffs();
        for (Long it : staffs){
            AssignmentCustomerEntity assignmentCustomerEntity = new AssignmentCustomerEntity();
            assignmentCustomerEntity.setAssignment(customerEntity);

            assignmentCustomerEntity.setUserEntity(userRepository.findById(it).get());
            assignmentCustomerRepository.save(assignmentCustomerEntity);
        }
    }
}
