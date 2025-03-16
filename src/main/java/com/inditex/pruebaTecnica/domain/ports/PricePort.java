package com.inditex.pruebaTecnica.domain.ports;

import com.inditex.pruebaTecnica.domain.model.dto.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PricePort {
    List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}
