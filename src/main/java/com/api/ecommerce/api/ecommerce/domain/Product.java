package com.api.ecommerce.api.ecommerce.domain;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
public class Product implements Serializable {
    private int productId;
    private int brandID;
    private int priceList;
    private LocalDateTime startDatePrice;
    private double price;
    private String curr;
}
