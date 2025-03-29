package com.javaweb.service.impl;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.AssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignmentBuildingServiceImpl implements AssignmentBuildingService {
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteAssignmentBuilding(Long[] ids) {
//        for (Long it : ids){
//            BuildingEntity buildingEntity = buildingRepository.findById(it).get();
//            assignmentBuildingRepository.deleteByAssignment(buildingEntity);
//        }
        assignmentBuildingRepository.deleteByAssignment_IdIn(ids);
    }

    @Override
    public void addAssignmentBuildingEntity(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        assignmentBuildingRepository.deleteByAssignment(buildingEntity);
        List<Long> staffs = assignmentBuildingDTO.getStaffs();
        for (Long it : staffs){
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            assignmentBuildingEntity.setAssignment(buildingEntity);

            assignmentBuildingEntity.setUserEntity(userRepository.findById(it).get());
            assignmentBuildingRepository.save(assignmentBuildingEntity);
        }
        
    }
}
