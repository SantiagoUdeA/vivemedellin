package com.vivemedellin.valoracion_comentarios.user.repository;

import com.vivemedellin.valoracion_comentarios.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
