package com.vivemedellin.valoracion_comentarios.organizer.mapper;

import com.vivemedellin.valoracion_comentarios.organizer.dto.OrganizerDTO;
import com.vivemedellin.valoracion_comentarios.organizer.entity.Organizer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizerMapper {
    OrganizerMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(OrganizerMapper.class);
    OrganizerDTO toDTO(Organizer organizer);
    Organizer toEntity(OrganizerDTO organizerDTO);
}
