package com.api.ecommerce.api.ecommerce.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "PRICE_LIST")
    private int priceList;

    @Column(name= "product_id")
    private int productId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="brandId")
    private Brand brand;

    @Column(name= "START_DATE")
    private LocalDateTime startDate;

    @Column(name= "END_DATE")
    private LocalDateTime endDate;

    @Column(name= "PRIORITY")
    private int priority;

    @Column(name= "PRICE")
    private double price;

    @Column(name= "CURR")
    private String curr;
}
