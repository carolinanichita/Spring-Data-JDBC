package spring.data.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.data.jdbc.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
