package br.com.blog.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "comentario_seq", sequenceName = "comentario_seq", initialValue = 1, allocationSize = 1)
public class Comentario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Comentario(String comentario, Post postId, Usuario usuarioId) {
		super();
		this.comentario = comentario;
		this.postId = postId;
		this.usuarioId = usuarioId;
	}

	public Comentario(Long id, String comentario, Post postId, Usuario usuarioId) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.postId = postId;
		this.usuarioId = usuarioId;
	}

	public Comentario() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "comentario_seq")
	private Long id;
	private String comentario;
	
	@ManyToOne()
	@JoinColumn(name = "id_post", nullable = false)
	private Post postId;
	
	@ManyToOne()
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuarioId;
}
