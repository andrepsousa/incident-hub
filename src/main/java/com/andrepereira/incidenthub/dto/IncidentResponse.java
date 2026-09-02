package com.andrepereira.incidenthub.dto;

import com.andrepereira.incidenthub.domain.Incident;
import com.andrepereira.incidenthub.domain.IncidentSeverity;
import com.andrepereira.incidenthub.domain.IncidentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record IncidentResponse(

        UUID id,
        String code,
        String title,
        String description,
        IncidentSeverity severity,
        IncidentStatus status,
        String affectedService,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime resolvedAt

) {

    public static IncidentResponse from(Incident incident) {
        return new IncidentResponse(
                incident.getId(),
                incident.getCode(),
                incident.getTitle(),
                incident.getDescription(),
                incident.getSeverity(),
                incident.getStatus(),
                incident.getAffectedService(),
                incident.getCreatedAt(),
                incident.getUpdatedAt(),
                incident.getResolvedAt()
        );
    }
}