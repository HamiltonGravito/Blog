package br.com.blog.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Comentario;

@Repository
@EnableJpaRepositories(basePackageClasses = {ComentarioRepository.class})
@EntityScan(basePackageClasses = {Comentario.class})
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

	@Query(value = "SELECT * FROM comentario WHERE id_post = ?1", nativeQuery = true)
	List<Comentario> findByComentarioPorPostId(Long id);
	
	@Query(value = "SELECT * FROM comentario WHERE id_usuario = ?1", nativeQuery = true)
	List<Comentario> findByComentarioPorUsuario(Long id);
}
