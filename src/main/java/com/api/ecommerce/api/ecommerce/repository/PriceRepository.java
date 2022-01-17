package com.api.ecommerce.api.ecommerce.repository;

import com.api.ecommerce.api.ecommerce.model.Prices;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PriceRepository  extends JpaRepository<Prices, Integer> {

    Prices findFirstByStartDateAndProductIdAndBrand(LocalDate starDate, int productId, int brandId, Sort sort);
}
