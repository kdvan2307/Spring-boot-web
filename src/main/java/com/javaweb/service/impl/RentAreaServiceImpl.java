package com.javaweb.service.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.RentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentAreaServiceImpl implements RentAreaService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Override
    public void addRentArea(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingDTO.getId()).get();
        rentAreaRepository.deleteByBuilding(buildingEntity);
        String s = buildingDTO.getRentArea();
        List<Long> longList = Arrays.stream(s.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
        for (Long it : longList) {
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setValue(it);
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntities.add(rentAreaEntity);
        }
        rentAreaRepository.saveAll(rentAreaEntities);
    }

    @Override
    public void deleteRentArea(Long[] ids) {
//        for (Long it : ids){
//            BuildingEntity buildingEntity = buildingRepository.findById(it).get();
//            rentAreaRepository.deleteByBuilding(buildingEntity);
//        }
        rentAreaRepository.deleteByBuilding_IdIn(ids);
    }
}
