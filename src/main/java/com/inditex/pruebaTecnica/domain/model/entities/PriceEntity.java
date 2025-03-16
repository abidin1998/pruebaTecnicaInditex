package com.inditex.pruebaTecnica.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Getter
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "PRICE")
    private Double priceAmount;

    @Column(name = "curr")
    private String curr;

}
