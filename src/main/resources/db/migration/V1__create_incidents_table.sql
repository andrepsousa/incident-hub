CREATE TABLE incidents
(
    id UUID PRIMARY KEY,

    code VARCHAR(30) NOT NULL UNIQUE,

    title VARCHAR(150) NOT NULL,

    description TEXT NOT NULL,

    severity VARCHAR(20) NOT NULL,

    status VARCHAR(20) NOT NULL,

    affected_service VARCHAR(100) NOT NULL,

    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    resolved_at TIMESTAMP WITHOUT TIME ZONE,

    CONSTRAINT chk_incident_severity
        CHECK (
            severity IN (
                         'P1_CRITICAL',
                         'P2_HIGH',
                         'P3_MEDIUM',
                         'P4_LOW'
                )
            ),

    CONSTRAINT chk_incident_status
        CHECK (
            status IN (
                       'OPEN',
                       'INVESTIGATING',
                       'IDENTIFIED',
                       'MONITORING',
                       'RESOLVED',
                       'CLOSED'
                )
            )
);
