package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="staffid")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity assignment;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingEntity getAssignment() {
        return assignment;
    }

    public void setAssignment(BuildingEntity assignment) {
        this.assignment = assignment;
    }


}
