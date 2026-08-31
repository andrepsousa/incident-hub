package com.andrepereira.incidenthub.repository;

import com.andrepereira.incidenthub.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IncidentRepository extends JpaRepository<Incident, UUID> {

    Optional<Incident> findByCode(String code);

    boolean existsByCode(String code);
}
