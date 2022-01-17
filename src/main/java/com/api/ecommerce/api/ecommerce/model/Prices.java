package com.api.ecommerce.api.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int productId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="brandId")
    private Brand brand;

    @Column(name= "START_DATE")
    private LocalDateTime startDate;

    @Column(name= "END_DATE")
    private LocalDateTime endDate;

    @Column(name= "PRICE_LIST")
    private int priceList;

    @Column(name= "PRIORITY")
    private int priority;

    @Column(name= "PRICE")
    private double price;

    @Column(name= "CURR")
    private String curr;
}
