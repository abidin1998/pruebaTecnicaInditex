package com.inditex.pruebaTecnica.infra.adapter.out.db.price;

import com.inditex.pruebaTecnica.domain.model.dto.Price;
import com.inditex.pruebaTecnica.domain.ports.PricePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceImpl implements PricePort {

    private final PriceRepository priceRepository;

    private final PriceMapper mapper;


    @Override
    public List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate) {
        return priceRepository.
                findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                brandId,productId,startDate,endDate).stream().map(mapper::priceToPriceDTO).toList();
    }
}
