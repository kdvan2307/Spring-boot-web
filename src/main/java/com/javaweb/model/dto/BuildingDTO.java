package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BuildingDTO extends AbstractDTO{

    private String name;
    private Long floorArea;
    private String district;
    private String ward;
    private String street;
    private Long numberOfBasement;
    private String structure;
    private String serviceFee;
    private String rentpricescription;
    private String carFee;
    private String motoFee;
    private String overtimeFee;
    private String electricityBill;
    private String deposit;
    private String pay;
    private String direction;
    private String rentalTerm;
    private String decorationTime;
    private String brokerageFee;
    private String note;
    private Long level;
    private String rentArea;
    private Long rentPrice;
    private String managerName;
    private String managerPhone;
    private List<String> typeCode;

}