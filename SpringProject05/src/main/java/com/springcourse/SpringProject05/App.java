package com.springcourse.SpringProject05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//BeanFactory bean= new XmlBeanFactory(new FileSystemResource("spring.xml"));
        //System.out.println( "Hello World!" );
    	
    	/*What this line does is create a object of every class mentioned in the spring.xml file and store it in a spring container.
    	 * Now when we try to get the object using .getBean() method it return the object related to the keyword here it is tempclass.
         * It also to be mentioned that when it creates a object it uses default constructor and not a parameterized one so be sure to
         * declare that in the xml file we are gonna use parameterized ones,
    	 * */
    	ApplicationContext bean=new ClassPathXmlApplicationContext("spring.xml");

        TempClass ob=(TempClass)bean.getBean("tempclass");
        ob.code2();
                
        /*Note by default the Spring framework only create one object in the memory for each class. To create multiple objects
    	 * we have to mention in the spring.xml file scope="prototype", this indicates that Spring has to create a new object every time 
    	 * we use getBean() method that the along with id and class tags.*/
        TempClass2 ob1=(TempClass2)bean.getBean("tempclass2");
        ob1.age=15;
        System.out.println(ob1.age);
        ob1.code3();

        TempClass2 ob2=(TempClass2)bean.getBean("tempclass2");
        ob2.age=30;
        System.out.println(ob1.age);
        ob2.code3();
        
        /*This class was an example of how Spring manages to set values of private instance variables*/
        TempClass3 ob3=(TempClass3)bean.getBean("tempclass3");
        System.out.println(ob3.getAge());
        ob3.getLaptop().compile();
        System.out.println(ob3.getAge1());
        ob3.getLaptop1().compile();

        TempClass4 ob4=(TempClass4)bean.getBean("tempclass4");
        ob4.getComp().compile();
    }
}
