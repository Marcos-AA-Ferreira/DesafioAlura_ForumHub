CREATE TABLE Topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    visivel BOOLEAN NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_de_criacao DATETIME NOT NULL,
    status VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL
);