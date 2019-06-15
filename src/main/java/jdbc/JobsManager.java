package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component 
public class JobsManager  {
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

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateTwo(int e1,int e2)  {
		TransactionStatus status =	TransactionAspectSupport.currentTransactionStatus();
		System.out.println("Transaction Begins");
		
		int count = jdbcTemplate.update
		  ("update employees set salary = salary + 1000 where employee_id = ?",
 		  e1);
		if (count == 0) {
			//throw new RuntimeException();
			status.setRollbackOnly();
			// return;
		}
		
		System.out.println("First Update Done");

		count = jdbcTemplate.update
  	       ("update employees set salary = salary + 2000 where employee_id = ?",
		   e2);
	    if (count == 0)
	    	status.setRollbackOnly();
		    // throw new RuntimeException();
	    System.out.println("New Transaction " + status.isNewTransaction());
	    System.out.println("Rollback ? " + status.isRollbackOnly());
	    System.out.println("Update Ends");
	}
	
	public void run(String... args) {
		// showJobCount();
		// listJobs();
		// listJobs2();
		// listJobTitles();
		// updateMinSalary();
		try {
		  updateTwo(110,320);
		  System.out.println("Operation Completed!");
		}
		catch(Exception ex) {
		  System.out.println("Operation Failed");
		}

	}

}
