package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringProject04Application {

	public static void main(String[] args) {
		
		/*SpringApplication.run return a ConfigurableApplicationContext object or just ApplicationContext object
		 * with this object we can ask the spring framework to handle the creation and maintaining of object 
		 * which removes the manual part. This is known as Dependency Injection. For a class to be maintained and 
		 * for it's object to be created by Spring rather than manual we have to add the @Component Annotation
		 * at the start of the class which signify it's maintained by SPring*/
		ConfigurableApplicationContext context=SpringApplication.run(SpringProject04Application.class, args);
		
		//.getBeans returns a object of the class given in the Parameters.
		TempClass ob=context.getBean(TempClass.class);
		ob.code();
		ob.code2();
	}

}
