package br.com.blog.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "post_seq", sequenceName = "post_seq", initialValue = 1, allocationSize = 1)
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "post_seq")
	private Long id;
	private String titulo;
	private String texto;
	
	@Transient
	private List<String> listaLinks;
	
	@Transient
	private List<String> listaImagens;
	
	@ManyToOne()
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuarioId;
	
	@OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Link> links;
	
	@OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Imagem> imagens;
	
	@OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comentario> comentarios;
	
}
