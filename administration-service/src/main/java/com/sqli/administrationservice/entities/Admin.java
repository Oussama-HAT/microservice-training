package com.sqli.administrationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Admin implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
