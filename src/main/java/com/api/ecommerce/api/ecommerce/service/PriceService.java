package com.api.ecommerce.api.ecommerce.service;

import com.api.ecommerce.api.ecommerce.domain.Product;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {

    /**
     * Final product price
     *
     * @return Final price
     */
    Product getProductByPrice(LocalDateTime starDate, int productId, int brandId);
}
