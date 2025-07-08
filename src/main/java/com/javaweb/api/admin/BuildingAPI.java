package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.AssignmentBuildingService;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private AssignmentBuildingService assignmentBuildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        //xuong DB de update hoac them moi
        return ResponseEntity.ok(buildingService.addOrUpdateBuilding(buildingDTO));
    }

    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable Long[] ids) {
        //xuong DB de xoa building theo danh sach id gui ve
        buildingService.deleteBuildings(ids);
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO result = buildingService.listStaffs(id);
        return result;
    }

    @PostMapping("/assignment")
    public void updateAssingmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingService.addAssignmentBuildingEntity(assignmentBuildingDTO);

    }
}
