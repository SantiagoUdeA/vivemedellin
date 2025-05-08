package com.vivemedellin.valoracion_comentarios.organizer.dto;

import com.vivemedellin.valoracion_comentarios.organizer.entity.Organizer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Organizer}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerDTO implements Serializable {
    Long id;
    @NotNull
    @Size(max = 50)
    @NotEmpty
    @NotBlank
    String firstName;
    @NotNull
    @Size(max = 50)
    @NotEmpty
    @NotBlank
    String lastName;
    @NotNull
    @Size(max = 100)
    @Email
    @NotEmpty
    @NotBlank
    String email;
}