package com.vivemedellin.valoracion_comentarios.report.service;

import com.vivemedellin.valoracion_comentarios.report.dto.CreateReportDto;
import com.vivemedellin.valoracion_comentarios.report.dto.ReportDto;
import com.vivemedellin.valoracion_comentarios.report.entity.ReportReason;
import com.vivemedellin.valoracion_comentarios.report.factory.ReportFactory;
import com.vivemedellin.valoracion_comentarios.report.mapper.ReportMapper;
import com.vivemedellin.valoracion_comentarios.report.repository.ReportRepository;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.ForbiddenAccessException;
import com.vivemedellin.valoracion_comentarios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportService {

    private final ReportMapper reportMapper;
    private final ReportFactory reportFactory;
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportMapper reportMapper, ReportFactory reportFactory, ReportRepository repository) {
        this.reportMapper = reportMapper;
        this.reportFactory = reportFactory;
        this.reportRepository = repository;
    }

    public ReportDto createReport(CreateReportDto input){
        var report = reportFactory.createFromDto(input);
        var savedReport = reportRepository.save(report);
        return reportMapper.toDto(savedReport);
    }

    // Returns the reports for the events associated to the events
    // that admin owns
    public List<ReportDto> getReportsByAdminId(UUID adminId){
        return this.reportRepository
                .findAllByAdminId(adminId)
                .stream()
                .map(reportMapper::toDto)
                .toList();
    }

    public ReportDto deleteReport(Long reportId, UUID adminId) {
        var report = this.reportRepository
                .findById(reportId)
                .orElseThrow(() -> new NotFoundException("Could not find that report"));

        if(!report.getReview().getEvent().getAdmin().getId().equals(adminId))
            throw new ForbiddenAccessException();

        this.reportRepository.delete(report);
        return reportMapper.toDto(report);
    }
}
