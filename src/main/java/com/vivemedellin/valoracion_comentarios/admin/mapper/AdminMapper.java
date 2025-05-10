package com.vivemedellin.valoracion_comentarios.admin.mapper;

import com.vivemedellin.valoracion_comentarios.admin.entity.Admin;
import com.vivemedellin.valoracion_comentarios.admin.entity.AdminDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(AdminMapper.class);
    Admin toEntity(AdminDto adminDto);
    AdminDto toDTO(Admin admin);

}
