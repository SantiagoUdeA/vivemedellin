package com.vivemedellin.valoracion_comentarios.review.repository;

import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
