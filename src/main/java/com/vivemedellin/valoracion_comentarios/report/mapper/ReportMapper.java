package com.vivemedellin.valoracion_comentarios.report.mapper;

import com.vivemedellin.valoracion_comentarios.report.dto.ReportDto;
import com.vivemedellin.valoracion_comentarios.report.entity.Report;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReviewMapper.class})
public interface ReportMapper {
    Report toEntity(ReportDto reportDto);

    ReportDto toDto(Report report);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Report partialUpdate(ReportDto reportDto, @MappingTarget Report report);
}