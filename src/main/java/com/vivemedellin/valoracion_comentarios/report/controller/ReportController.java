package com.vivemedellin.valoracion_comentarios.report.controller;

import com.vivemedellin.valoracion_comentarios.report.dto.CreateReportDto;
import com.vivemedellin.valoracion_comentarios.report.dto.ReportDto;
import com.vivemedellin.valoracion_comentarios.report.entity.ReportReason;
import com.vivemedellin.valoracion_comentarios.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.vivemedellin.valoracion_comentarios.shared.util.AuthUtils.getUserId;

@Controller
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PreAuthorize("hasRole('admin')")
    @QueryMapping
    public List<ReportDto> allReports(){
        var id = getUserId();
        return this.reportService.getReportsByAdminId(id);
    }

    @PreAuthorize("hasRole('user')")
    @MutationMapping
    public ReportDto createReport(@Argument("input") CreateReportDto input){
        var test = this.reportService.createReport(input);
        System.out.println(test);
        return  test;
    }
}
