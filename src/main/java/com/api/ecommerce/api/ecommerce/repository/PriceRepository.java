package com.api.ecommerce.api.ecommerce.repository;

import com.api.ecommerce.api.ecommerce.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface PriceRepository  extends JpaRepository<Prices, Integer> {

    @Query(value = "SELECT p.* FROM PRICES p " +
            "WHERE p.start_date <= :startDate " +
            "AND p.end_date >= :startDate " +
            "AND p.product_id = :productId " +
            "AND p.brand_id = :brandId " +
            "AND p.priority = (SELECT max(mp.prioritY) FROM PRICES mp " +
            "                     WHERE mp.start_date <= :startDate " +
            "                     AND mp.end_date >= :startDate " +
            "                     AND mp.product_id = :productId " +
            "                     AND mp.brand_id = :brandId) " +
            "AND p.start_date >= (SELECT max(start_date) FROM PRICES p2 " +
            "                     WHERE p2.start_date <= :startDate " +
            "                     AND p2.end_date >= :startDate " +
            "                     AND p2.product_id = :productId " +
            "                     AND p2.brand_id = :brandId )",
            nativeQuery = true)
    Prices findFirstByStartDateAndProductIdAndBrand(
            @Param("startDate") LocalDateTime startDate,
            @Param("productId") int productId,
            @Param("brandId") int brandId);
}
