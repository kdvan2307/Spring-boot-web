package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.CustomerResponse;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-25T16:37:17+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class CustomerConverterImpl implements CustomerConverter {

    @Override
    public CustomerEntity toEntity(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        if ( customerRequest.getId() != null ) {
            customerEntity.id( customerRequest.getId() );
        }
        if ( customerRequest.getFullName() != null ) {
            customerEntity.fullName( customerRequest.getFullName() );
        }
        if ( customerRequest.getPhone() != null ) {
            customerEntity.phone( customerRequest.getPhone() );
        }
        if ( customerRequest.getEmail() != null ) {
            customerEntity.email( customerRequest.getEmail() );
        }
        if ( customerRequest.getCompanyName() != null ) {
            customerEntity.companyName( customerRequest.getCompanyName() );
        }
        if ( customerRequest.getDemand() != null ) {
            customerEntity.demand( customerRequest.getDemand() );
        }
        if ( customerRequest.getStatus() != null ) {
            customerEntity.status( customerRequest.getStatus() );
        }
        if ( customerRequest.getCreatedDate() != null ) {
            customerEntity.createdDate( new SimpleDateFormat().format( customerRequest.getCreatedDate() ) );
        }
        if ( customerRequest.getModifiedDate() != null ) {
            customerEntity.modifiedDate( new SimpleDateFormat().format( customerRequest.getModifiedDate() ) );
        }
        if ( customerRequest.getCreatedBy() != null ) {
            customerEntity.createdBy( customerRequest.getCreatedBy() );
        }
        if ( customerRequest.getModifiedBy() != null ) {
            customerEntity.modifiedBy( customerRequest.getModifiedBy() );
        }

        return customerEntity.build();
    }

    @Override
    public CustomerResponse toResponse(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        if ( customerEntity.getFullName() != null ) {
            customerResponse.setFullName( customerEntity.getFullName() );
        }
        if ( customerEntity.getPhone() != null ) {
            customerResponse.setPhone( customerEntity.getPhone() );
        }
        if ( customerEntity.getEmail() != null ) {
            customerResponse.setEmail( customerEntity.getEmail() );
        }
        if ( customerEntity.getDemand() != null ) {
            customerResponse.setDemand( customerEntity.getDemand() );
        }
        if ( customerEntity.getCreatedBy() != null ) {
            customerResponse.setCreatedBy( customerEntity.getCreatedBy() );
        }
        if ( customerEntity.getCreatedDate() != null ) {
            customerResponse.setCreatedDate( customerEntity.getCreatedDate() );
        }
        if ( customerEntity.getStatus() != null ) {
            customerResponse.setStatus( customerEntity.getStatus() );
        }

        return customerResponse;
    }

    @Override
    public void updateEntity(CustomerEntity customerEntity, CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return;
        }

        if ( customerRequest.getId() != null ) {
            customerEntity.setId( customerRequest.getId() );
        }
        if ( customerRequest.getFullName() != null ) {
            customerEntity.setFullName( customerRequest.getFullName() );
        }
        if ( customerRequest.getPhone() != null ) {
            customerEntity.setPhone( customerRequest.getPhone() );
        }
        if ( customerRequest.getEmail() != null ) {
            customerEntity.setEmail( customerRequest.getEmail() );
        }
        if ( customerRequest.getCompanyName() != null ) {
            customerEntity.setCompanyName( customerRequest.getCompanyName() );
        }
        if ( customerRequest.getDemand() != null ) {
            customerEntity.setDemand( customerRequest.getDemand() );
        }
        if ( customerRequest.getStatus() != null ) {
            customerEntity.setStatus( customerRequest.getStatus() );
        }
        if ( customerRequest.getCreatedDate() != null ) {
            customerEntity.setCreatedDate( new SimpleDateFormat().format( customerRequest.getCreatedDate() ) );
        }
        if ( customerRequest.getModifiedDate() != null ) {
            customerEntity.setModifiedDate( new SimpleDateFormat().format( customerRequest.getModifiedDate() ) );
        }
        if ( customerRequest.getCreatedBy() != null ) {
            customerEntity.setCreatedBy( customerRequest.getCreatedBy() );
        }
        if ( customerRequest.getModifiedBy() != null ) {
            customerEntity.setModifiedBy( customerRequest.getModifiedBy() );
        }
    }
}
