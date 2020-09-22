package br.com.blog.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Comentario;

@Repository
@EnableJpaRepositories(basePackageClasses = {ComentarioRepository.class})
@EntityScan(basePackageClasses = {Comentario.class})
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
