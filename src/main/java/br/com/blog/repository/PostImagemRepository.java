package br.com.blog.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.PostImagem;

@Repository
@EnableJpaRepositories(basePackageClasses = {PostImagemRepository.class})
@EntityScan(basePackageClasses = {PostImagem.class})
public interface PostImagemRepository extends JpaRepository<PostImagem, Long> {
	
	@Query(value = "SELECT * FROM post_imagem INNER JOIN post ON (post.id = venda_produto.post_id) WHERE imagem_id = ?1", nativeQuery = true)
	List<PostImagem> imagensPorPost (Long id);
}
