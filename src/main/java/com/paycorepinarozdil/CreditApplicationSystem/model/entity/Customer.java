package com.paycorepinarozdil.CreditApplicationSystem.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @NotBlank(message = "identity number can not be null")
    @Column(name = "identity_number",unique = true)
    @Pattern(regexp ="[1-9][0-9]{10}")
    private String identityNumber;

    @NotBlank(message = "firstname can not be null")
    private String firstname;

    @NotBlank(message = "lastname can not be null")
    private String lastname;

    @NotNull(message = "salary can not be null")
    private double salary;

    @NotBlank(message = "phone can not be null")
    @Pattern(regexp ="[0][0-9]{10}")
    private String phone;

    @Column(name = "create_date")
    private Date createDate ;

    @Column(name = "update_date")
    private Date updateDate ;

    @JsonIgnore
    @OneToOne(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private CustomerCreditScore customerCreditScore;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<CreditApplication> creditApplications;

}
