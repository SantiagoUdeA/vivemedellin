package com.vivemedellin.valoracion_comentarios.report.factory;

import com.vivemedellin.valoracion_comentarios.report.dto.CreateReportDto;
import com.vivemedellin.valoracion_comentarios.report.entity.Report;
import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReportFactory {

    public Report createFromDto(CreateReportDto dto){
        var builder = Report.builder();
        var review = new Review();
        review.setId(dto.getReviewId());
        builder.review(review);
        builder.reason(dto.getReason());
        return builder.build();
    }
}
