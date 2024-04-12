package spring.data.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.data.jdbc.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
