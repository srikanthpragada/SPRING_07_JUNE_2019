package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class JobsManager implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(JobsManager.class, args);
	}

	public void showJobCount() {
		Integer count = jdbcTemplate.queryForObject
				("select count(*) from jobs", Integer.class);
		System.out.println("Count = " + count);
	}
	
	public void listJobs() {
		List<Job> jobs = jdbcTemplate.query
				("select * from jobs", 
   				new RowMapper<Job>() {
					@Override
					public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Job j = new Job();
                        j.setId(rs.getString("job_id"));
                        j.setTitle(rs.getString("job_title"));
                        return j;
					}
				}
			);
				
		for(Job j : jobs)
			System.out.println(j.getTitle());
	}
	
	public void listJobs2() {
		List<Job> jobs = jdbcTemplate.query
				("select * from jobs", 
			    // RowMapper is implemented using Lambda Expression 
   				(rs, rowNum) -> new Job(rs.getString("job_id"), 
   						                rs.getString("job_title"))
			);
				
		for(Job j : jobs)
			System.out.println(j.getTitle());
	}
	
	public void listJobTitles() {
		List<String> titles = jdbcTemplate.query
				("select job_title from jobs", 
			    // RowMapper is implemented using Lambda Expression 
   				(rs, rowNum) ->  new String(rs.getString("job_title"))
			);
				
		for(String title : titles)
			System.out.println(title);
	}
	
	public void updateMinSalary() {
		int count = jdbcTemplate.update
		  ("update jobs set min_salary = min_salary + 1000  where job_id = ?",
 		  "IT_PROG");
        System.out.println("No. of rows updated : " + count);		
	}

	public void run(String... args) {
		// showJobCount();
		// listJobs();
		// listJobs2();
		//listJobTitles();
		updateMinSalary();

	}

}
