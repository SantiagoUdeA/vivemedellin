package com.vivemedellin.valoracion_comentarios.category.service;

import com.vivemedellin.valoracion_comentarios.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
