package com.inditex.pruebaTecnica.application.service;

import com.inditex.pruebaTecnica.domain.model.dto.Price;
import com.inditex.pruebaTecnica.domain.ports.PricePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PricePort pricePort;

    public Price getPrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        List<Price> prices =
                pricePort.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId, productId, applicationDate, applicationDate);

        return prices.isEmpty() ? null : prices.get(0); // Return the highest priority price
    }
}
