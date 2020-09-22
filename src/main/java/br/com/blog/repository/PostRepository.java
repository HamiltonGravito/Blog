package br.com.blog.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Post;

@Repository
@EnableJpaRepositories(basePackageClasses = {PostRepository.class})
@EntityScan(basePackageClasses = {Post.class})
public interface PostRepository extends JpaRepository<Post, Long> {

}
