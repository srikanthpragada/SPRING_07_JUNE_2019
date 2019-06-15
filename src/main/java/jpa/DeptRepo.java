package jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends
    CrudRepository<Department,Integer> {
   
	@Query("from Department d where d.id > ?1")
	List<Department> getDepartments(int deptid);
	
	@Query(value="select count(*) from departments", nativeQuery=true)
	int  getCount();
}
