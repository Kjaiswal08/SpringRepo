package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerForRest {
	
	@Autowired
	EmployeeRepo empsRepo;
	
	/*@ResponseBody This annotation is required if the Mapping sends a list/set of data rather that Jsp page
	 * But since we have used @RestController for the entire class it add the @ResponseBody automatically.
	 * But if we only use @Controller we would have to individual mention which function return data and not 
	 * Jsp pages.*/
	@GetMapping("/rest_employees")
	public List<Employee> get_employess() {
		return empsRepo.findAll();
	}
	
	/*Now if look we see that it returns List but we check in Postman(API tester) we would see it automatically
	 * gets converted to JSON this happens due to Jackson library which is included when add spring web dependency
	 * We can also return data in XML by adding another Library Jackson Data XML.*/
	
	

	@GetMapping("/rest_employee_id/{empid}")
	public Employee get_employee_by_id(@PathVariable("empid") int empid) {
		//System.out.println("Getting employee by id");
		return empsRepo.getReferenceById(empid);
	}
	
	/*Now we can also mention what format the data should be send or received in json or xml. By default
	 * it does both but if we want to specify we can add produce="application/xml or json" to send data and
	 * consume="application/xml or json" when receiving data. This tags a included int the mapping annotation
	 * like this  @PostMapping(path="rest_employee",consume="application/xml")*/
	
	@PostMapping("/rest_employee")
	public Employee add_employee(@RequestBody Employee emp) {
		
		empsRepo.save(emp);
		return emp;
	}
	
	@GetMapping("rest_employee_name/{name}")
	public List<Employee> get_employees_by_name(@PathVariable("name") String name){
		return empsRepo.findByEmpname(name);
	}
}
