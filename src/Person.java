import java.security.InvalidParameterException;
import java.util.*;
public class Person
{int age;
String name;
//char gender;
String gender;
static Scanner sc=new Scanner(System.in);  
Person(String n)
{

	do{
	 	
		try
		{
			System.out.println("Enter age"); 
			 
			age=sc.nextInt();
		    name=n;
		    System.out.println("enter gender(M/F)");
		    gender=sc.next();
		    if(gender.equals("male")||gender.equals("female")||gender.equals("Male")||gender.equals("female")
		    		||gender.equals("M")||gender.equals("F")||gender.equals("m")||gender.equals("f")||gender.equals("MALE")
		    		||gender.equals("FEMALE"))
		    	
			break;
		    else
		    	throw new IllegalGenderException ("thats something new :D please enter either male or female");
		}
		catch(InputMismatchException e)
		{
			System.out.println("wrong input format.please retry");
			sc.next();
		}
		catch(IllegalGenderException e)
		{
			System.out.println(e);
		}
	}while(true);
   
}
Person()
{
	do{
	try
	{
		   System.out.println("Enter age"); 
		   age=sc.nextInt();
		   System.out.println("Enter name");

	name=sc.next();
	   System.out.println("Enter gender");
	gender=sc.next();   
	if(gender.equals("male")||gender.equals("female")||gender.equals("Male")||gender.equals("female")
    		||gender.equals("M")||gender.equals("F")||gender.equals("m")||gender.equals("f")||gender.equals("MALE")
    		||gender.equals("FEMALE"))
    	
	break;
    else
    	throw new IllegalGenderException ();

	
	}catch(InputMismatchException e)
	{
		System.out.println("wrong input.please retry");
		sc.next();
	}
	catch(IllegalGenderException e)
	{
		System.out.println(e);
	}
	}	while(true);
    
}

public String toString()
{
	return "\n"+"Name:"+name+"\n";
}

/*void display() 
{
	System.out.println("name="+name);
	System.out.println("age="+age);
	System.out.println("sex="+sex);
}*/


String getName()
{
	return name;
}
String getGender()
{
	return gender;
}
int age()
{
	return age;
}
void changeAge(int newAge)
{ 
		age=newAge;
	

   }
void changeName(String newName)
{
	
		name=newName;
	
}
void changeGender(String newGender)
{
		gender=newGender;
	
}


}
