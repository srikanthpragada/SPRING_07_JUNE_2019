package jpa;

import org.springframework.data.repository.CrudRepository;

public interface DeptRepo extends
    CrudRepository<Department,Integer> {

}
