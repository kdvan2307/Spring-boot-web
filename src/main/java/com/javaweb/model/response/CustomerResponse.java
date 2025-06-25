package com.javaweb.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private String fullName;
    private String phone;
    private String email;
    private String demand;
    private String createdBy;
    private String createdDate;
    private String status;

}
