package com.javaweb.entity;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="building")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ward")
    private String ward;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "managername")
    private String managerName;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "floorarea")
    private Long floorArea;

    @Column(name = "numberofbasement")
    private Long numberofBasement;

    @Column(name = "managerphone")
    private String managerPhone;

//	@Column(name = "emptyarea")
//	private String emptyArea;
    @Column(name = "type")
    private String type;

    @Column(name = "rentprice")
    private Long rentPrice;

    @Column(name = "servicefee")
    private String serviceFee;

    @Column(name = "brokeragefee")
    private Long brokerageFee;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                                                                            orphanRemoval = true)
    private List<RentAreaEntity> items = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid",nullable = false))
    private List<UserEntity> usersEntities = new ArrayList<>();

    public List<UserEntity> getUsersEntities() {
        return usersEntities;
    }

    public void setUsersEntities(List<UserEntity> usersEntities) {
        this.usersEntities = usersEntities;
    }
//    @Column(name = "type")
//    private String typeCode;

//    public String getTypeCode() {
//        return typeCode;
//    }
//
//    public void setTypeCode(String typeCode) {
//        this.typeCode = typeCode;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RentAreaEntity> getItems() {
        return items;
    }

    public void setItems(List<RentAreaEntity> items) {
        this.items = items;
    }

    public Long getNumberofBasement() {
        return numberofBasement;
    }

    public void setNumberofBasement(Long numberofBasement) {
        this.numberofBasement = numberofBasement;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }


    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public Long getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }
    //	public String getEmptyArea() {
//		return emptyArea;
//	}
//	public void setEmptyArea(String emptyArea) {
//		this.emptyArea = emptyArea;
//	}
    public Long getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }
    public String getServiceFee() {
        return serviceFee;
    }
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
    public Long getBrokerageFee() {
        return brokerageFee;
    }
    public void setBrokerageFee(Long brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

}