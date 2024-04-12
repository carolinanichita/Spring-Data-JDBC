package spring.data.jdbc;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import org.slf4j.Logger;
import spring.data.jdbc.entity.Author;
import spring.data.jdbc.entity.Book;
import spring.data.jdbc.repository.AuthorRepository;
import spring.data.jdbc.repository.BookRepository;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(JdbcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("CRUD features started");

		log.info("CREATE");

		Book egoIsTheEnemy = new Book();
		egoIsTheEnemy.setName("Ego is the enemy");
		egoIsTheEnemy.setSummary("The fight to master our greatest opponent");
		bookRepository.save(egoIsTheEnemy);

		Author ryanHoliday = new Author();
		ryanHoliday.setFirstName("Ryan");
		ryanHoliday.setLastName("Holiday");
		authorRepository.save(ryanHoliday);

		log.info("READ");

		log.info(String.valueOf(bookRepository.findById(ryanHoliday.getId())));
		log.info(String.valueOf(authorRepository.findById(ryanHoliday.getId())));

		log.info("UPDATE");

		egoIsTheEnemy.setSummary("The fight to master our greatest opponent from Ryan Holiday");
		bookRepository.save(egoIsTheEnemy);

		ryanHoliday.setLastName("Holi");
		authorRepository.save(ryanHoliday);

		log.info("DELETE");

		bookRepository.delete(egoIsTheEnemy);
		authorRepository.delete(ryanHoliday);

		log.info("CRUD features done");
	}
}
