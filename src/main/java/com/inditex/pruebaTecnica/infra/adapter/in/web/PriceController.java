package com.inditex.pruebaTecnica.infra.adapter.in.web;

import com.inditex.pruebaTecnica.domain.model.dto.Price;
import com.inditex.pruebaTecnica.application.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService pricePort;

    @GetMapping
    public Price getPrice(@RequestParam("applicationDate") String applicationDateStr,
                          @RequestParam("productId") Long productId,
                          @RequestParam("brandId") Long brandId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime applicationDate = LocalDateTime.parse(applicationDateStr, formatter);

        return pricePort.getPrice(
                brandId, productId, applicationDate);
    }
}
