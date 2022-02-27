package com.paycorepinarozdil.CreditApplicationSystem.model.entity;

import com.paycorepinarozdil.CreditApplicationSystem.model.entity.CreditApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CreditApplicationResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "credit limit can not be null")
    @Column(name = "credit_limit")
    private double creditLimit;

    @NotNull(message = "credit result can not be null")
    @Column(name = "credit_result")
    private String creditResult;

    @Column(name = "create_date")
    private Date createDate;

    @NotNull(message = "credit application can not be null")
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "credit_application_id")
    private CreditApplication creditApplication;
}
