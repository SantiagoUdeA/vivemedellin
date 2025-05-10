package com.vivemedellin.valoracion_comentarios.admin.repository;

import com.vivemedellin.valoracion_comentarios.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
