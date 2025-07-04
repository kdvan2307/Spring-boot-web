package com.javaweb.entity;
import lombok.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

//    @Column(name = "type")
//    private String typeCode;


}