package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.stereotype.Component;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(buildingSearchRequest.getName())
                .setFloorArea(buildingSearchRequest.getFloorArea())
                .setWard(buildingSearchRequest.getWard())
                .setStreet(buildingSearchRequest.getStreet())
                .setDistrict(buildingSearchRequest.getDistrict())
                .setNumberOfBasement(buildingSearchRequest.getNumberOfBasement())
                .setTypeCode(buildingSearchRequest.getTypeCode())
                .setManagerName(buildingSearchRequest.getManagerName())
                .setManagerPhoneNumber(buildingSearchRequest.getManagerPhone())
                .setRentPriceFrom(buildingSearchRequest.getRentPriceFrom())
                .setRentPriceTo(buildingSearchRequest.getRentPriceTo())
                .setAreaFrom(buildingSearchRequest.getAreaFrom())
                .setAreaTo(buildingSearchRequest.getAreaTo())
                .setStaffId(buildingSearchRequest.getStaffId())
                .build();
        return buildingSearchBuilder;
    }
}
