package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.CustomerResponse;

import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CustomerConverter {
    CustomerEntity toEntity(CustomerRequest customerRequest);

    CustomerResponse toResponse(CustomerEntity customerEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget CustomerEntity customerEntity, CustomerRequest customerRequest);

}
