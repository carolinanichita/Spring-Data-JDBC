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
import spring.data.jdbc.mapper.AuthorMapper;
import spring.data.jdbc.mapper.BookMapper;
import spring.data.jdbc.repository.AuthorRepository;
import spring.data.jdbc.repository.BookRepository;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(JdbcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private AuthorMapper authorMapper;

	@Override
	public void run(String... args) throws Exception {
		log.info("find and insert book using ibatis mapper");

		log.info(String.valueOf(bookMapper.getBook(1L)));
		log.info(String.valueOf(bookMapper.saveBook("Zero to one", "Notes on startups, or How to build the future")));

		log.info(String.valueOf(authorMapper.getAuthor(1L)));
		log.info(String.valueOf(authorMapper.saveAuthor("Peter", "Theil")));
	}
}
