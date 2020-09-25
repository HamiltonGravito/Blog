package br.com.blog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "imagem_seq", sequenceName = "imagem_seq", initialValue = 1, allocationSize = 1)
public class Imagem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "imagem_seq")
	private Long id;
	
	@Column(name = "imagem_url")
	private String imagemUrl;
	
	@ManyToOne()
	@JoinColumn(name = "id_album", nullable = true)
	private Album albumId;
		
	@OneToMany
	@JoinColumn(name = "id_imagem", nullable = true)
	private List<PostImagem> postImagem;
	
	public Imagem(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
}
