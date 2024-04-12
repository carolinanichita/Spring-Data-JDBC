package spring.data.jdbc;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import org.slf4j.Logger;
@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(JdbcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		List bookList = jdbcTemplate.queryForList("select * from book order by id desc");
		log.info(String.valueOf(bookList));

		List authorList = jdbcTemplate.queryForList("select * from author order by id desc");
		log.info(String.valueOf(authorList));
	}
}
