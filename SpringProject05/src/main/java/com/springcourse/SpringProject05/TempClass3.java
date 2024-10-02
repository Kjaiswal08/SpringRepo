package com.springcourse.SpringProject05;

public class TempClass3 {
	private int age;
	
	/*This class is maintained by Spring. When the spring.xml file is used in the main class using 
	 * ClassPathXmlApplicationContext("spring.xml");it creates an object of this
	 * class it also uses the private instance variables using the setter method. To make sure this works we have to set the
	 * name of the Setter method as set{VariableName} only then can Spring can initialize the variables.*/
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	/*As previously we have seen the use of property tag in xml to set values of primitive type instance variables 
	 * But here we take it a step forward and set the values of non-primitive type instance values using Spring Framework.
	 * The Method name rule must be followed as before. The only change is in the xml file where the property tag now have
	 * "ref" instead of "value" part. For this to work we also have to create a bean of the Class of whose object we
	 * are trying to initialize. Now pass the id of the bean in the "ref" part of the property.
	*/
	private Laptop laptop;

	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	/*Here we have used constructors to set the values of the two private instance variable. To do this simply add a new
	 * tag to the bean <constructor-args> which either have a value/ref part of primitive and non-primitive values resp.
	 */
	private int age1;
	private Laptop laptop1;
	public TempClass3(int age1,Laptop laptop){
		this.age1=age1;
		this.laptop1=laptop;
	}
	public int getAge1() {
		return age1;
	}
	public Laptop getLaptop1() {
		return laptop1;
	}

	public void code4() {System.out.println("Coding 4");}
}
