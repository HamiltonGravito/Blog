CREATE SEQUENCE usuario_seq START 1 INCREMENT 1;
CREATE SEQUENCE post_seq START 1 INCREMENT 1;
CREATE SEQUENCE comentario_seq START 1 INCREMENT 1;

CREATE TABLE usuario(
    id BIGINT PRIMARY KEY DEFAULT nextval('usuario_seq') NOT NULL,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(10) NOT NULL
);

CREATE TABLE post(
    id BIGINT PRIMARY KEY DEFAULT nextval('post_seq') NOT NULL,
    post TEXT NOT NULL
);

CREATE TABLE comentario(
    id BIGINT PRIMARY KEY DEFAULT nextval('comentario_seq') NOT NULL,
    comentario VARCHAR(200) NOT NULL
);
