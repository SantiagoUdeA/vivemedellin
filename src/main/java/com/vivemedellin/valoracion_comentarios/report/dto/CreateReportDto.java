package com.vivemedellin.valoracion_comentarios.report.dto;

import com.vivemedellin.valoracion_comentarios.report.entity.ReportReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class CreateReportDto {
    @NonNull
    ReportReason reason;
    @NonNull
    Long reviewId;
}
