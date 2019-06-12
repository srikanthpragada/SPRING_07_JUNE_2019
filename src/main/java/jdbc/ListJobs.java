package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ListJobs implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
	   SpringApplication.run(ListJobs.class, args);
	}
	
	public void run(String ... args) {
		System.out.println("Testing Spring JDBC");
		System.out.println(jdbcTemplate);
		
	}

}
