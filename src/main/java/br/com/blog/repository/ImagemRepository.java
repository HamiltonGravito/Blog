package br.com.blog.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Imagem;

@Repository
@EnableJpaRepositories(basePackageClasses = {ImagemRepository.class})
@EntityScan(basePackageClasses = {Imagem.class})
public interface ImagemRepository extends JpaRepository<Imagem, Long>{

}
