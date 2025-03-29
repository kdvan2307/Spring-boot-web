package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    void deleteByBuilding(BuildingEntity building);
    void deleteByBuilding_IdIn(Long[] ids);
    List<RentAreaEntity> findAllByBuilding(BuildingEntity building);
}
