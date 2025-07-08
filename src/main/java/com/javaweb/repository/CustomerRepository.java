package com.javaweb.repository;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> , CustomerRepositoryCustom {
    public void deleteByIdIn(Long[] ids);
}
