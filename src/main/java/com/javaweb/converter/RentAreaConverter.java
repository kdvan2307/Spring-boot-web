package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentAreaConverter {
    public List<RentAreaEntity> toListRentAreaEntity(BuildingDTO buildingDTO, BuildingEntity buildingEntity){
        String s = buildingDTO.getRentArea();
        List<Long> longList = Arrays.stream(s.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
        for (Long it : longList){
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntity.setValue(it);
            rentAreaEntities.add(rentAreaEntity);
        }
        return rentAreaEntities;
    }
}
