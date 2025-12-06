
CREATE TABLE IF NOT EXISTS tickets (
    id              INTEGER      PRIMARY KEY AUTOINCREMENT,
    creator         INTEGER,
    destinatary     INTEGER,
    technician      INTEGER,
    item            VARCHAR(255),
    to_do           VARCHAR(255),
    details         VARCHAR(255),
    place           VARCHAR(255),
    status          VARCHAR(255) DEFAULT 'ANALISE',
    created_at      TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP
);

CREATE TABLE IF NOT EXISTS ticket_observers (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    ticket_id INTEGER,
    observer_id INTEGER,
    FOREIGN KEY (ticket_id) REFERENCES tickets(id)
);