package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long cusId;
    @Column(name = "customer_name",length = 50, nullable = false)
    private String cusName;
    private boolean gender;
    private LocalDate birthday;
    private String address;
    private String email;
    private String phone;
}
