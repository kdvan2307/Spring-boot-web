package com.javaweb.repository;

import com.javaweb.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    public void deleteByIdIn(Long[] ids);
}
