package com.javaweb.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.District;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// chuyển đổi buildingEntity về BuildingSearchResponse( kiểu trả ra trên màn hình khách hàng)
@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    public BuildingSearchResponse toBuildingResponse(BuildingEntity item) {
        BuildingSearchResponse building = modelMapper.map(item, BuildingSearchResponse.class);

        List <RentAreaEntity> rentAreas = item.getItems();
        String areaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        building.setRentArea(areaResult);

        Map<String,String> districts = District.type();
        String districtName = "";
        if (item.getDistrict() != null && item.getDistrict()!= "") {
            districtName = districts.get(item.getDistrict());
        }
        if (districtName != null && districtName != "") {
            building.setAddress(item.getStreet() + ", " + item.getWard() + ", " + districtName);
        }

        return building;
    }
    public BuildingDTO toBuildingDTO(BuildingEntity building) {
        BuildingDTO dto = modelMapper.map(building, BuildingDTO.class);
        List<RentAreaEntity> rentAreas = rentAreaRepository.findAllByBuilding(building);
        String result = rentAreas.stream()
                .map(rentArea -> rentArea.getValue().toString())
                .collect(Collectors.joining(","));
        dto.setRentArea(result);

        List<String> type = Arrays.asList(building.getType().split(","));
        dto.setTypeCode(type);
        return dto;

    }
}
