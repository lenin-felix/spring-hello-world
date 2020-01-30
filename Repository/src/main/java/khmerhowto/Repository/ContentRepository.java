package khmerhowto.Repository;

import khmerhowto.Repository.Model.Category;
import khmerhowto.Repository.Model.Content;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ContentRepository extends JpaRepository<Content, Integer> {

	Page<Content> findByTitleContainingIgnoreCase(@Param("title") String title, Pageable pageable);

	List<Content> findAllBycategoryId(Integer id, Pageable pageable);


	Page<Content> findByTitleContainingIgnoreCaseAndCategoryIdAndStatus(@Param("title") String title, Integer c_id, int i, Pageable pageable);
	public Page<Content> findAllByOrderByIdDesc(Pageable pageable);
}
