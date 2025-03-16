package com.inditex.pruebaTecnica.infra.adapter.out.db.price;


import com.inditex.pruebaTecnica.domain.model.dto.Price;
import com.inditex.pruebaTecnica.domain.model.entities.PriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @InheritInverseConfiguration
    Price priceToPriceDTO(PriceEntity request);


}
