package com.api.ecommerce.api.ecommerce.model;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "BRAND_ID")
    private int brandId;
    private String name;
}
