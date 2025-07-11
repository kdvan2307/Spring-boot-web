package com.javaweb.model.request;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CustomerSearchRequest extends AbstractDTO {
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;
}
