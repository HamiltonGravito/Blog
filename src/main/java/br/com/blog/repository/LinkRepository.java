package br.com.blog.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.blog.model.Link;


@Repository
@EnableJpaRepositories(basePackageClasses = {LinkRepository.class})
@EntityScan(basePackageClasses = {Link.class})
public interface LinkRepository extends JpaRepository<Link, Long> {

	@Query(value = "SELECT * FROM link WHERE id_post = ?1", nativeQuery = true)
	List<Link> findByLinkPorPostId(Long id);
}
