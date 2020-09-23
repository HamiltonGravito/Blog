CREATE SEQUENCE album_seq START 1 INCREMENT 1;

CREATE TABLE album(
    id BIGINT PRIMARY KEY DEFAULT nextval('album_seq') NOT NULL,
    nome VARCHAR(50) NOT NULL,

    id_usuario BIGINT NOT NULL,
    FOREIGN KEY(id_usuario) REFERENCES usuario(id)
);