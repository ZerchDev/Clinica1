CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY, -- BIGSERIAL para auto-incrementar
    usuario VARCHAR(100) NOT NULL,
    contraseña VARCHAR(340) NOT NULL

);

