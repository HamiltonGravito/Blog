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
@SequenceGenerator(name = "postImg_seq", sequenceName = "postImg_seq", initialValue = 1, allocationSize = 1)
@Table(name = "post_imagem")
public class PostImagem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "postImg_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_post")
	private Post post;
	@ManyToOne
	@JoinColumn(name = "id_imagem")
	private Imagem imagem;
}
