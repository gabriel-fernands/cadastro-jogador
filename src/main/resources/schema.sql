CREATE TABLE IF NOT EXISTS JOGADOR (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    codinome VARCHAR(255) NOT NULL,
    grupo_codinome VARCHAR(255) NOT NULL,
    CONSTRAINT unique_codinome UNIQUE (codinome, grupo_codinome)
);
