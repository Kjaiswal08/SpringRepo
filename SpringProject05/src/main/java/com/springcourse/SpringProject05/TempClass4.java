package com.springcourse.SpringProject05;

public class TempClass4 {
    /*Here we have tried to implement another feature of Spring Called autowire. This is used to initialize non-primitive 
     * instance variables based upon criteria such as {ByType, ByName, Constructor, Default}. But why do we need it.
     * Lets say we have two beans of two different classes which implement the same Interface and we need and object of the 
     * that interface(here it's Computer). Now what autowire does it try and find objects in the memory which has the same 
     * parameter(ByType,etc..), and attach one of them with instance variable(Here laptop and desktop).
     * But there still one problem lets say we use Bytype to match variable, now since there have both 
     * laptop and Desktop in memory which implement Computer, JVM gets confused which to choose. So to resolve this issue we
     * have to add another part to the bean declaration of that class which is "primary" in xml. This tells if there are two objects
     * of same type and we have used autowire to initialize a instance variable then use the one with "primary" set as True.
     * Note: This only works with default Constructors.
     */
    private Computer comp;
    public void setComp(Computer comp){
        this.comp=comp;
    }
    public Computer getComp(){return this.comp;}
}
