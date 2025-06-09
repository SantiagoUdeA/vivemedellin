package com.vivemedellin.valoracion_comentarios.report.entity;

import lombok.Getter;

@Getter
public enum ReportReason {
    SPAM,
    OFFENSIVE,
    INAPPROPRIATE,
    PERSONAL_INFORMATION,
    ADVERTISING
}
