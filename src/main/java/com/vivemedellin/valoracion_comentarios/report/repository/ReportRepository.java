package com.vivemedellin.valoracion_comentarios.report.repository;

import com.vivemedellin.valoracion_comentarios.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query("""
    SELECT r
    FROM Report r
    JOIN Review rev ON rev.id = r.review.id
    JOIN Event e ON e.id = rev.event.id
    JOIN Admin a ON a.id = e.admin.id
    WHERE a.id = :adminId
    """)
    List<Report> findAllByAdminId(UUID adminId);
}
