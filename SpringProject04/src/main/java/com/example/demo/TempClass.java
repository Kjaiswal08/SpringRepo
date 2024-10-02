package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TempClass {
	public void code() {System.out.println("Coding");}
	@Autowired
	Laptop lap;
	/*The Autowired annotation indicates that the class is maintained by Spring and to initialize the object 
	 * reference with a object of the class present in the memory  
	*/
	public void code2() {lap.code2();}
}
