package br.com.blog.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Album;

@Repository
@EnableJpaRepositories(basePackageClasses = {AlbumRepository.class})
@EntityScan(basePackageClasses = {Album.class})
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
