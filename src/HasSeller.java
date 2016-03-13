import java.util.Scanner;
import java.util.Vector;


public class HasSeller {
	int m;
	static Scanner sc=new Scanner(System.in);
	
	Vector<Seller> s=new Vector<Seller>();
	
	void addSeller(User u,String n)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			s.add(new Seller(n));
		}
		else
    	{
    		System.out.println("you are not authorized to add seller");
    	}
	}
    void addSeller(User u)
	{
    	if(u.getRegister().getUsername().equals("admin"))
		s.add(new Seller());
    	else
    	{
    		System.out.println("you are not authorized to add seller");
    	}
	}

	void removeSeller(User u,String sellerName,HasMobiles hm)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			if(s.removeElement(getSeller(sellerName)))
				{
				System.out.println("seller successfully removed");

				hm.deleteMobileS(u,sellerName);
				}
				
			else
				System.out.println("seller does not exist");
		}
		else
    	{
    		System.out.println("you are not authorized to add seller");
    	}
	}


Seller getSeller(String n)
{
	for(int i=0;i<s.size();i++)
	{
		if((s.get(i)).getName().equals(n))
		{
			return s.get(i);
		}
	}
	return null;
}
void displaySeller()
{
	for(int i=0;i<s.size();i++)
	{
		System.out.println(s.get(i)+"\n");
	}
}

boolean sellerExists(String n)
{
	for(int i=0;i<s.size();i++)
	{
		if((s.get(i)).getName().equals(n))
		{
			return true;
		}
	}
	return false;
}

}