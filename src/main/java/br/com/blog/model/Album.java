package br.com.blog.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "album_seq", sequenceName = "album_seq", initialValue = 1, allocationSize = 1)
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "album_seq")
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "albumId")
	@JsonIgnore
	private List<Imagem> imagens;
	
	@ManyToOne()
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuarioId;
}
