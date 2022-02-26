package com.paycorepinarozdil.CreditApplicationSystem.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CustomerCreditScore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "identity number can not be null")
    @Column(name = "identity_number",unique = true)
    private String identityNumber;

    @NotNull(message = "firstname can not be null")
    private String firstname;

    @NotNull(message = "lastname can not be null")
    private String lastname;

    @NotNull(message = "salary can not be null")
    private double salary;

    @NotNull(message = "phone can not be null")
    private String phone;

    @Column(name = "create_date")
    private Date createDate = java.sql.Date.valueOf(LocalDate.now());

    @Column(name = "update_date")
    private Date updateDate = java.sql.Date.valueOf(LocalDate.now());

    @JsonIgnore
    @OneToOne(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private CustomerCreditScore customerCreditScore;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<CreditApplication> creditApplications;

}
