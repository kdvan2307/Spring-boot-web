package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.AssignmentCutomerDTO;

public interface AssignmentCustomerService {
    public void deleteAssignmentCustomer(Long[] ids);
    public void addAssignmentCustomerEntity(AssignmentCutomerDTO assignmentCutomerDTO);
}
