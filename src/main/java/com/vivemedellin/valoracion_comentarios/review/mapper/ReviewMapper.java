package com.vivemedellin.valoracion_comentarios.review.mapper;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
    ReviewDTO toDTO(Review review);
    Review toEntity(ReviewDTO reviewDTO);
}
