package com.javaweb.converter;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.TransactionResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-08T17:40:15+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class TransactionConverterImpl implements TransactionConverter {

    @Override
    public TransactionResponse toResponse(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }

        TransactionResponse transactionResponse = new TransactionResponse();

        if ( transactionEntity.getId() != null ) {
            transactionResponse.setId( transactionEntity.getId() );
        }
        if ( transactionEntity.getModifiedDate() != null ) {
            transactionResponse.setModifiedDate( transactionEntity.getModifiedDate() );
        }
        if ( transactionEntity.getModifiedBy() != null ) {
            transactionResponse.setModifiedBy( transactionEntity.getModifiedBy() );
        }
        if ( transactionEntity.getCreatedDate() != null ) {
            transactionResponse.setCreatedDate( transactionEntity.getCreatedDate() );
        }
        if ( transactionEntity.getCreatedBy() != null ) {
            transactionResponse.setCreatedBy( transactionEntity.getCreatedBy() );
        }
        if ( transactionEntity.getTransactionDetail() != null ) {
            transactionResponse.setTransactionDetail( transactionEntity.getTransactionDetail() );
        }

        return transactionResponse;
    }

    @Override
    public TransactionEntity toEntity(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        TransactionEntity.TransactionEntityBuilder transactionEntity = TransactionEntity.builder();

        if ( transactionDTO.getId() != null ) {
            transactionEntity.id( transactionDTO.getId() );
        }
        if ( transactionDTO.getCode() != null ) {
            transactionEntity.code( transactionDTO.getCode() );
        }
        if ( transactionDTO.getCustomerId() != null ) {
            transactionEntity.customerId( Long.parseLong( transactionDTO.getCustomerId() ) );
        }
        if ( transactionDTO.getTransactionDetail() != null ) {
            transactionEntity.transactionDetail( transactionDTO.getTransactionDetail() );
        }

        return transactionEntity.build();
    }
}
