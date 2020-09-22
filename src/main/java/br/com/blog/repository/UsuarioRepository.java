package br.com.blog.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Usuario;

@Repository
@EnableJpaRepositories(basePackageClasses = {UsuarioRepository.class})
@EntityScan(basePackageClasses = {Usuario.class})
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
