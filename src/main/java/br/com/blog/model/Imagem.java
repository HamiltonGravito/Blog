package br.com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "imagem_seq", sequenceName = "imagem_seq", initialValue = 1, allocationSize = 1)
public class Imagem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "imagem_seq")
	private Long id;
	@Lob
	private Byte[] imagem;
}
