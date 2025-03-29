package com.javaweb.service;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentAreaService{
    public void addRentArea(BuildingDTO buildingDTO);
    public void deleteRentArea (Long[] ids);
}
