package com.sqli.customerservice.entities;

import com.sqli.customerservice.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer implements Serializable {

    private static final long serialVersionUID = -1L;
@Id
    @Column(name = "account_no")
    private Long accountNo;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

}
