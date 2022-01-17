package com.api.ecommerce.api.ecommerce.domain;


import lombok.Builder;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
public class Product implements Serializable {
    private int productId;
    private int brandID;
    private int priceListCurr;
    private LocalDate startDatePrice;
    private double price;
}
