package com.andrepereira.incidenthub.exception;

public class IncidentNotFoundException extends RuntimeException {

    public IncidentNotFoundException(String code) {
        super("Incident not found: " + code);
    }
}
