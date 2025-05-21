package com.vivemedellin.valoracion_comentarios.event.repository;

import com.vivemedellin.valoracion_comentarios.event.dto.EventWithReviewStatsDTO;
import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>{

    @Query("""
    SELECT
        e.id AS id,
        e.title AS title,
        e.description AS description,
        e.date AS date,
        e.location AS location,
        e.price AS price,
        COUNT(r.id) AS totalReviews,
        COALESCE(AVG(r.rating), 0.0) AS averageRating
    FROM Event e
    LEFT JOIN Review r ON r.event.id = e.id
    GROUP BY e.id, e.title, e.description, e.date, e.location, e.price
    """)
    List<EventWithReviewStatsDTO> findAllWithReviewStats();
}
