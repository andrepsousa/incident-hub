package com.andrepereira.incidenthub.dto;

import com.andrepereira.incidenthub.domain.IncidentSeverity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateIncidentRequest(
        @NotBlank
        @Size(max = 150)
        String title,

        @NotBlank
        @Size(max = 5000)
        String description,

        @NotNull
        IncidentSeverity severity,

        @NotNull
        @Size(max = 100)
        String affectedService

) {
}
