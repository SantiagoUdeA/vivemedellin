package com.vivemedellin.valoracion_comentarios.event.mapper;

import com.vivemedellin.valoracion_comentarios.event.dto.EventDto;
import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EventMapper.class);
    EventDto toDTO(Event event);
    Event toEntity(EventDto eventDTO);
}
