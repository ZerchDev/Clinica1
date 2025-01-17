CREATE TABLE medicos (
    id BIGSERIAL PRIMARY KEY, -- BIGSERIAL para auto-incrementar
    nombre VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100) NOT NULL,
    apellidoMaterno VARCHAR(100) NOT NULL,
    telefono VARCHAR(10) NOT NULL UNIQUE,
    cedula VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    especialidad VARCHAR(100) NOT NULL
);

