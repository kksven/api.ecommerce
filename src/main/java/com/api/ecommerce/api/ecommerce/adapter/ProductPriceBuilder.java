package com.api.ecommerce.api.ecommerce.adapter;

import com.api.ecommerce.api.ecommerce.domain.Product;
import com.api.ecommerce.api.ecommerce.model.Prices;
import org.springframework.stereotype.Component;


@Component
public class ProductPriceBuilder {

    public static Product build(Prices prices){
        return Product.builder()
                .productId(prices.getProductId())
                .priceList(prices.getPriceList())
                .startDatePrice(prices.getStartDate())
                .brandID(prices.getBrand().getBrandId())
                .price(prices.getPrice())
                .curr(prices.getCurr())
                .build();
    }
}
