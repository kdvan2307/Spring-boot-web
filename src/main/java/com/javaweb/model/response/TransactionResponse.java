package com.javaweb.model.response;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TransactionResponse extends AbstractDTO {
    private Date createdDate;
    private String createdBy;
    private String transactionDetail;
}

