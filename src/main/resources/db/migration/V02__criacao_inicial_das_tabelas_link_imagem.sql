CREATE SEQUENCE link_seq START 1 INCREMENT 1;
CREATE SEQUENCE imagem_seq START 1 INCREMENT 1;

CREATE TABLE link(
    id BIGINT PRIMARY KEY DEFAULT nextval('link_seq') NOT NULL,
    link TEXT NOT NULL,

    id_post BIGINT NOT NULL,
    FOREIGN KEY(id_post) REFERENCES post(id)

);

CREATE TABLE imagem(
     id BIGINT PRIMARY KEY DEFAULT nextval('link_seq') NOT NULL,
     imagem BYTEA NOT NULL
);