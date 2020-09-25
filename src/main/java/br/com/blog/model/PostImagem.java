package br.com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "post_imagem_seq", sequenceName = "post_imagem_seq", initialValue = 1, allocationSize = 1)
@Table(name = "post_imagem")
public class PostImagem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "post_imagem_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_post", nullable = false)
	private Post post;
	@ManyToOne
	@JoinColumn(name = "id_imagem", nullable = false)
	private Imagem imagem;
	
	public PostImagem(Imagem imagem,Post post) {
		this.imagem = imagem;
		this.post = post;
	}
}
