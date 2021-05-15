import java.util.ArrayList;
public class Person
{
    private int myAge;
    private String myName;
    
    public Person(int age, String name){
        myAge = age;
        myName = name;
    }
    
    public int getAge(){ return this.myAge; }
    
    public String getName(){ return this.myName; }
}
