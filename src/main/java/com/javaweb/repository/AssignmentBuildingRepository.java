package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
    void deleteByAssignment(BuildingEntity buildingEntity);
    void deleteByAssignment_IdIn(Long[] ids);
}
