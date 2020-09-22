ALTER TABLE comentario ADD COLUMN id_post BIGINT NOT NULL;
ALTER TABLE comentario ADD FOREIGN KEY(id_post) REFERENCES post(id);
ALTER TABLE comentario ADD COLUMN id_usuario BIGINT NOT NULL;
ALTER TABLE comentario ADD FOREIGN KEY(id_usuario) REFERENCES usuario(id);