package com.javaweb.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "assignmentcustomer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentCustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="staffid")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerEntity assignment;
}
