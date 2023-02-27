package com.mtesazi.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "Email_ID", nullable = false)
    private String emailId;

    @Column(name = "Telephone", nullable = false)
    private String telephone;

    @Column(name = "Address", nullable = false)
    private String address;
}