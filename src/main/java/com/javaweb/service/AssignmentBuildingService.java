package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;

public interface AssignmentBuildingService {
    public void deleteAssignmentBuilding(Long[] ids);
    public void addAssignmentBuildingEntity(AssignmentBuildingDTO assignmentBuildingDTO);
}
