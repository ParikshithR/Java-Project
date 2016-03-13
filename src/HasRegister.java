import java.util.*;
public class HasRegister {
Vector<Register> h=new Vector<Register>();
Scanner sc=new Scanner(System.in);

void addRegister() 
{
	h.addElement(new Register(this));
}

void removeRegister(User u)
{   boolean b=false;
	if(u.getRegister().getUsername().equals("admin"))
	{
		if(h.isEmpty())
		{System.out.println("No users exist");}
		else 
		{
				System.out.print("Enter user to be removed:\n");
				b=h.remove(getRegisterU(sc.nextLine(),u));
				if(b==true)
				{
							System.out.print(" user removed:\n");
				}
				else
				{
					System.out.println("User does not exist");
				}
		}
	}
		else
		{
			System.out.print("Unauthorized access");
		}
	}

/*
Boolean user_exists(Register r)
{
	for(int i=0;i<h.size();i++)
{
	if(h.get(i).getUsername().equals(r.getUsername()) && h.get(i).getPassword().equals(r.getPassword()))
	{   System.out.println("user exists");
		return true;
	}
}
		return false;
}
*/

Register getRegisterU(String n,User u)
{
	if(u.getRegister().getUsername().equals("admin"))
	{	for(int i=0;i<h.size();i++)
		{
		if(h.get(i).getUsername().equals(n))
		{  
			return h.get(i);
		}
		}
	
	}
	else
		System.out.println("unauthorized entry");
	return null;
}


Register getRegisterP(String pass,User u)
{
	if(u.getRegister().getPassword().equals("admin"))
	{	for(int i=0;i<h.size();i++)
		{
		if(h.get(i).getPassword().equals(pass))
		{
			return h.get(i);
		}
		}
		
	}
	else
	{
		System.out.println("unauthrized entry");
	}
	return null;
}
Register getRegister(String username,String password)
{
	for(int i=0;i<h.size();i++)
	{
	if(h.get(i).getPassword().equals(password)&&h.get(i).getUsername().equals(username))
	{
		return h.get(i);
	}
	
	}
	return null;
	
}
boolean registerExists(String username,String password)
{
	for(int i=0;i<h.size();i++)
	{
	if(h.get(i).getPassword().equals(password)&&h.get(i).getUsername().equals(username))
	{
		return true;
	}
	
	}
	return false;
	
}
boolean registerExists(String n)
{
	for(int i=0;i<h.size();i++)
{
	if(h.get(i).getUsername().equals(n) )
	{  
		return true;
	}
}
		return false;
}
/*void login_check(Register q)
{
	if(q.username.equals("admin") && q.password.equals("mstoreadmin"))
	{   
		System.out.println("Welcome admin");
		
	}
	else 
	{
		System.out.println("Welcome user"+q.username);
		
	}	
}
*/
void loginCheck(User u)
{
	if(u.getRegister().getUsername().equals("admin") && u.getRegister().getPassword().equals("mstoreadmin"))
	{   
		System.out.println("Welcome admin");
		
	}
	else 
	{
		System.out.println("Welcome "+u.getRegister().getUsername());
		
	}	
}

}




