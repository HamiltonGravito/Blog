package br.com.blog.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Imagem;

@Repository
@EnableJpaRepositories(basePackageClasses = {ImagemRepository.class})
@EntityScan(basePackageClasses = {Imagem.class})
public interface ImagemRepository extends JpaRepository<Imagem, Long>{

	@Query(value = "SELECT nextval('imagem_nome_seq ')", nativeQuery = true)
	Long correnteValueSeqImagem();
	
	@Query(value = "SELECT * FROM imagem WHERE id_post = ?1", nativeQuery = true)
	List<Imagem> findByImagemPorPostId(Long id);
	
}
