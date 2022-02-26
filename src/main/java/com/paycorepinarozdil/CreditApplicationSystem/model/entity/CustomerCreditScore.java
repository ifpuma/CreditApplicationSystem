package com.paycorepinarozdil.CreditApplicationSystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerCreditScore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "credit score can not be null!")
    @Column(name = "credit_score")
    private int creditScore;

    @NotNull(message = "customer can not be null")
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
