package com.andrepereira.incidenthub.controller;

import com.andrepereira.incidenthub.dto.CreateIncidentRequest;
import com.andrepereira.incidenthub.dto.IncidentResponse;
import com.andrepereira.incidenthub.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public ResponseEntity<IncidentResponse> create(
            @Valid @RequestBody CreateIncidentRequest request
    ) {

        IncidentResponse response = incidentService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<IncidentResponse>> findAll() {

        return ResponseEntity.ok(
                incidentService.findAll()
        );
    }

    @GetMapping("/{code}")
    public ResponseEntity<IncidentResponse> findByCode(
            @PathVariable String code
    ) {

        return ResponseEntity.ok(
                incidentService.findByCode(code)
        );
    }
}