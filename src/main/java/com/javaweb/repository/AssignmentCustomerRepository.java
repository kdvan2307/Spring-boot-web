package com.javaweb.repository;

import com.javaweb.entity.AssignmentCustomerEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentCustomerRepository extends JpaRepository<AssignmentCustomerEntity, Long> {
    void deleteByAssignment(CustomerEntity customerEntity);
    void deleteByAssignment_IdIn(Long[] ids);
}
