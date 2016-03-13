import java.util.Scanner;
public class Register extends Person{
private String username;
private String password;
 
private static Scanner sc=new Scanner(System.in);
Register(HasRegister hr)  
{
initRegister(hr);
}
Register(){}
void scriptInit(String u,String p,String name,int age,String gender)
{

	username=u;
	password=p;
}
void changeUserName(String newUserName)
{
	username=newUserName;
}

void changePassword(String newPassword)
{
	password=newPassword;
}

void initRegister(HasRegister hr)
{
	String u;
	while(true)
	{	System.out.print("Enter username:");
		 u=sc.next();
		System.out.println();
		boolean b=hr.registerExists(u);
		if(b==false)
		{
			break;
		}
		else
		{
			System.out.println("username already exists");
		}
	}
	username=u;
	System.out.print("Enter password:");
	password=sc.next();
}
String getUsername()
{
	return username;
}
String getPassword()
{
	return password;
}


/*void display()
{
	System.out.println("username="+username);
	System.out.println("password="+password);
}*/
public String toString()
{
	return username+"\t"+password;
}
}
