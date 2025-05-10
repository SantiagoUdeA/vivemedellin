package com.vivemedellin.valoracion_comentarios.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.vivemedellin.valoracion_comentarios.user.entity.User}
 */
@Data
public class UserDto implements Serializable {
    UUID id;
    @NotNull
    @Length(max = 150)
    String displayName;
    @NotNull
    @Email
    @Length(max = 150)
    String email;
}