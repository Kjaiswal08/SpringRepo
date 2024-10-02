package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*TO work with JPA and DB properly confiqure the application.prop file and include dependencies of a Db Connector like Mysql and
 * Spring boot data Now just create a interface file and make it inherit JPARepository interface and pass the class equivalent of
 * the database here it's Employee and the type of Primary key.
 * 
 *  Now what extending JPARepo does it let us execute a lot of basic queries like to fetch all the records or just one record
 *  or save something into the DB without having us implement the methods ourselves. */

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	/*Now as mentioned in the previous comment that JpaRepo interface provides us with a lot of inbuilt queries but this function
	 * is not in built but still it works. The reason it Jpa also provides us something else called DSL(Domain Specific Language)
	 * what this say it that we can declare custom queries function using the attributes/variable of the table 
	 *  and define them, but still when they are called they will work. But the are conditions like if we want to find Something by
	 *  an attribute we have to declare the function name like findByAttributename() or if want it also to be descending by Other 
	 *  attribute then it becomes findByAttributenameOrderByOtherattributename()*/

	List<Employee> findByEmpname(String empname);
	
	
	/*This works the same way as the above function the only difference is that we supply the query through the annotation.
	 * This allows to pass more complex queries too */
	@Query("from Employee where empname= :name")
	List<Employee> find(@Param("name")String empname);

}
