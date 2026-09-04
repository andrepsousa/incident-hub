package com.andrepereira.incidenthub.service;

import com.andrepereira.incidenthub.domain.Incident;
import com.andrepereira.incidenthub.dto.CreateIncidentRequest;
import com.andrepereira.incidenthub.dto.IncidentResponse;
import com.andrepereira.incidenthub.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.time.Year;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Transactional
    public IncidentResponse create(CreateIncidentRequest request) {

        String code = generateIncidentCode();

        Incident incident = new Incident(
                code,
                request.title(),
                request.description(),
                request.severity(),
                request.affectedService()
        );

        Incident savedIncident = incidentRepository.save(incident);

        return IncidentResponse.from(savedIncident);
    }

    private String generateIncidentCode() {

        Long sequence = incidentRepository.nextCodeSequence();
        int currentYear = Year.now().getValue();

        return "INC-%d-%05d".formatted(currentYear, sequence);
    }

    @Transactional(readOnly = true)
    public List<IncidentResponse> findAll() {

        return incidentRepository
                .findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
                .stream()
                .map(IncidentResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public IncidentResponse findByCode(String code) {

        Incident incident = incidentRepository
                .findByCode(code)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Incident not found: " + code
                        )
                );

        return IncidentResponse.from(incident);
    }
}