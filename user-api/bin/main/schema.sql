CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    handle VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS roles (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS profiles (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(255),
    company VARCHAR(255),
    type VARCHAR(255),
    FOREIGN KEY (id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS tickets (
    id              INTEGER      PRIMARY KEY AUTOINCREMENT,
    creator         VARCHAR(255),
    destinatary     VARCHAR(255),
    technician      VARCHAR(255),
    item            VARCHAR(255),
    to_do           VARCHAR(255),
    details         VARCHAR(255),
    place           VARCHAR(255),
    status          VARCHAR(255) DEFAULT 'ANALISE',
    created_at      TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP,
    FOREIGN KEY (creator)     REFERENCES users(id),
    FOREIGN KEY (destinatary) REFERENCES users(id),
    FOREIGN KEY (technician)  REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS ticket_observers (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    ticket_id INTEGER,
    observer_id INTEGER,
    FOREIGN KEY (ticket_id) REFERENCES tickets(id),
    FOREIGN KEY (observer_id) REFERENCES users(id)
);