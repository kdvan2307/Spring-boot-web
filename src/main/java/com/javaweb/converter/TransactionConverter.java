package com.javaweb.converter;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TransactionConverter {
    TransactionResponse toResponse(TransactionEntity transactionEntity);
    TransactionEntity toEntity(TransactionDTO transactionDTO);;
}
