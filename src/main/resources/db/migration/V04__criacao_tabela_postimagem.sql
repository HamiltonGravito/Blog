CREATE SEQUENCE post_imagem_seq START 1 INCREMENT 1;

CREATE TABLE post_imagem(
 	id BIGINT PRIMARY KEY DEFAULT nextval('post_imagem_seq') NOT NULL,
    
    id_post BIGINT NOT NULL,
    FOREIGN KEY(id_post) REFERENCES post(id),
    
    id_imagem BIGINT NOT NULL,
    FOREIGN KEY(id_imagem) REFERENCES post(id)

);