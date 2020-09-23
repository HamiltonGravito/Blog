package br.com.blog.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", initialValue = 1, allocationSize = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "usuario_seq")
	private Long id;
	private String nome;
	private String senha;
	
	@OneToMany(mappedBy = "usuarioId")
	@JsonIgnore
	private List<Post> post;
	
	@OneToMany(mappedBy = "usuarioId")
	@JsonIgnore
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy = "usuarioId")
	@JsonIgnore
	private List<Album> albuns ;
	
}
