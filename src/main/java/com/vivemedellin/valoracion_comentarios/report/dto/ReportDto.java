package com.vivemedellin.valoracion_comentarios.report.dto;

import com.vivemedellin.valoracion_comentarios.report.entity.ReportReason;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.vivemedellin.valoracion_comentarios.report.entity.Report}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportDto implements Serializable {
    private Long id;
    private ReviewDto review;
    private ReportReason reason;
    private Instant createdAt;
}