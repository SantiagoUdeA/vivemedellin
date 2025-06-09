package com.vivemedellin.valoracion_comentarios.shared.util;

import com.vivemedellin.valoracion_comentarios.shared.exceptions.UnauthorizedAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class AuthUtils {

    public static UUID getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new UnauthorizedAccessException();
        }
        return UUID.fromString((String) auth.getPrincipal());
    }
}
