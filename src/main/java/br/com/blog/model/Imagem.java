package br.com.blog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "imagem_seq", sequenceName = "imagem_seq", initialValue = 1, allocationSize = 1)
public class Imagem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "imagem_seq")
	private Long id;
	
	@Transient
	private List<String> listaImagensSrt;
	
	@Column(name = "imagem_url")
	private String imagemUrl;
	
	@ManyToOne()
	@JoinColumn(name = "id_album", nullable = true)
	private Album albumId;
	
	@ManyToOne()
	@JoinColumn(name = "id_post", nullable = false)
	private Post postId;
	
	public Imagem(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
	public Imagem() {
		
	}

	public Imagem(Long id, String imagemUrl, Album albumId, Post postId) {
		super();
		this.id = id;
		this.imagemUrl = imagemUrl;
		this.albumId = albumId;
		this.postId = postId;
	}
}
