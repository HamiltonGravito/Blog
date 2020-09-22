package br.com.blog.model;

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
@SequenceGenerator(name = "link_seq", sequenceName = "link_seq", initialValue = 1, allocationSize = 1)
public class Link {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "link_seq")
	private Long id;
	private String link;
	@ManyToOne()
	@JoinColumn(name = "id_post", nullable = false)
	private Post postId;
}
