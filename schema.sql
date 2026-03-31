-- Tabelle für Studenten
CREATE TABLE studenten (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- Tabelle für Kurse
CREATE TABLE kurse (
    id SERIAL PRIMARY KEY,
    titel VARCHAR(100) NOT NULL
);
