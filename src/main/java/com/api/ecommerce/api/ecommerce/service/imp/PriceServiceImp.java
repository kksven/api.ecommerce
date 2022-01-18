package com.api.ecommerce.api.ecommerce.service.imp;

import com.api.ecommerce.api.ecommerce.adapter.ProductPriceBuilder;
import com.api.ecommerce.api.ecommerce.domain.Product;
import com.api.ecommerce.api.ecommerce.exception.CustomNotFoundException;
import com.api.ecommerce.api.ecommerce.repository.PriceRepository;
import com.api.ecommerce.api.ecommerce.service.PriceService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImp implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImp(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Product getProductByPrice(LocalDateTime starDate, int productId, int brandId) {

        return Optional.ofNullable(priceRepository.findFirstByStartDateAndProductIdAndBrand(starDate, productId, brandId))
                .map(ProductPriceBuilder::build)
                .orElseThrow(() -> new CustomNotFoundException("Price list information Not Found"));
    }
}
