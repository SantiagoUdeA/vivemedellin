package com.vivemedellin.valoracion_comentarios.admin.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Admin}
 */
@Value
public class AdminDto implements Serializable {
    UUID id;
    @NotNull
    @Email
    @NotEmpty
    @NotBlank
    @Length(min = 5, max = 100)
    String email;
    @NotNull
    @NotEmpty
    @NotBlank
    @Length(min = 3, max = 150)
    String displayName;
}