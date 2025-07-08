package com.javaweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "demand")
    private String demand;

    @Column(name = "status")
    private String status;

    @Column(name = "is_active")
    private String isActive;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentcustomer",
            joinColumns = @JoinColumn(name = "customerid",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid",nullable = false))
    private List<UserEntity> usersEntities = new ArrayList<>();

}
