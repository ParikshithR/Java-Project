import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class HasMobiles {
	static Scanner sc=new Scanner(System.in);
	Vector <Mobile> v=new Vector<Mobile>();
	
	
	void createMobile(User u,HasSeller h)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			String mobileName,sellerName;
			int q;
			Seller s;
			do{
			 	
				try
				{
			System.out.println("enter name of mobile and name of seller");
			 mobileName=sc.next();sellerName=sc.next();

			System.out.println("enter quantity");
			q=sc.nextInt();
				break;

				}

				catch(InputMismatchException e)
				{
					System.out.println("wrong input.please retry");
					sc.next();
				}
				
			}while(true);
			Mobile m=getMobile(sellerName,mobileName);
			if(m!=null)
			{
				m.addQuantity(u,q);
			}
			else
			{
				s=h.getSeller(sellerName);
				if(s!=null)
				{
					v.add(new Mobile(s,q,mobileName));
				}
				else
				{
					System.out.println("seller does not exist.enter details of the seller");
					h.addSeller(u,sellerName);
					s=h.s.lastElement();
					v.add(new Mobile(s,q,mobileName));
					
				}
			}
			
		}
		else
		{
			System.out.println("you are not authorized to add new mobiles");
		}
	}
	
	void deleteMobile(User u,String mobileName)
	{
	
		int x=0;
		if(u.getRegister().getUsername().equals("admin"))
		{
			while(true)
			{
				Mobile m=getMobile(mobileName);
				if(m==null)
					break;
				 v.remove(m);

					 x=1;
			}
			if(x==1)
			{
				System.out.println("mobile was succesfully removed");
			}
			else
				System.out.println("mobile doesn't exist");
			
		}
		else
		{
			System.out.println("ÿou are not authorized to delete mobile");
		}
	}
	void deleteMobileS(User u,String sellerName)
	{
	
		int x=0;
		if(u.getRegister().getUsername().equals("admin"))
		{
			while(true)
			{
				Mobile m=getMobileS(sellerName);
				if(m==null)
					break;
				 v.remove(m);

					 x=1;
			}
			if(x==1)
			{
				System.out.println("mobile was succesfully removed");
			}
			else
				System.out.println("mobile doesn't exist");
			
		}
		else
		{
			System.out.println("ÿou are not authorized to delete mobile");
		}
	}

	void deleteMobile(User u,int modelNo)
	{
	
		int x=0;
		if(u.getRegister().getUsername().equals("admin"))
		{
			while(true)
			{
				Mobile m=getMobile(modelNo);
				if(m==null)
					break;
				 v.remove(m);

					 x=1;
			}
			if(x==1)
			{
				System.out.println("mobile was succesfully removed");
			}
			else
				System.out.println("mobile doesn't exist");
			
		}
		else
		{
			System.out.println("ÿou are not authorized to delete mobile");
		}
	}
	
	void deleteMobile(User u,String mobileName,String sellerName)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			boolean b=v.remove(getMobile(sellerName,mobileName));
			if(b==true)
			{
				System.out.println("mobile was succesfully removed");
			}
			else
				System.out.println("mobile doesn't exist");
			
		}
		else
		{
			System.out.println("ÿou are not authorized to delete mobile");
		}
	}

	
	
	boolean mobileExists(String mobileName)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getMobileName().equals(mobileName))
			{
				return true;
			}
		}
		return false;
	}
	boolean mobileExistsS(String sellerName)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getSeller().getName().equals(sellerName))
			{
				return true;
			}
		}
		return false;
	}
	boolean mobileExists(int mobileModelNo)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getDetails().getModelNo()==mobileModelNo)
			{
				return true;
			}
		}
		return false;
	}
	boolean mobileExists(Seller sel,String mobileName)
	{
		for(int i=0;i<v.size();i++)
		{
			if((v.get(i).getMobileName().equals(mobileName))&&(v.get(i).getSeller().getName().equals(sel.getName())))
			{
				return true;
			}
		}
		return false;
	}
	int getMobileQuantity(String mobileName)
	{
	
		int x=0;
		int indexToStartFrom=0;
		
			while(true)
			{
				Mobile m=getMobile(mobileName,indexToStartFrom);
				if(m==null)
					break;
				 x+=m.getQuantity();
				 indexToStartFrom=v.indexOf(m)+1;
				 if(indexToStartFrom>=v.size())
					 break;
					 
			}
			return x;
			
		
	}

	Mobile getMobile(String mobileName)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getMobileName().equals(mobileName))
			{
				return v.get(i);
			}
		}
		return null;
	}
	Mobile getMobile(String mobileName,int indexToStartFrom) throws IndexOutOfBoundsException
	{
		if(indexToStartFrom>=v.size())
		{
			throw  new IndexOutOfBoundsException();
		}
		for(int i=indexToStartFrom;i<v.size();i++)
		{
			if(v.get(i).getMobileName().equals(mobileName))
			{
				return v.get(i);
			}
		}
		return null;
	}
	Mobile getMobileS(String sellerName)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getSeller().getName().equals(sellerName))
			{
				return v.get(i);
			}
		}
		return null;
	}
	Mobile getMobileS(String sellerName,int indexToStartFrom)throws IndexOutOfBoundsException
	{
		if(indexToStartFrom>=v.size())
		{
			throw  new IndexOutOfBoundsException();
		}
		for(int i=indexToStartFrom;i<v.size();i++)
		{
			if(v.get(i).getSeller().getName().equals(sellerName))
			{
				return v.get(i);
			}
		}
		return null;
	}
	Mobile getMobile(int mobileModelNo)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getDetails().getModelNo()==mobileModelNo)
			{
				return v.get(i);
			}
		}
		return null;
	}
	Mobile getMobile(int mobileModelNo,int indexToStartFrom) throws IndexOutOfBoundsException
	{
		if(indexToStartFrom>=v.size())
		{
			throw  new IndexOutOfBoundsException();
		}
		for(int i=indexToStartFrom;i<v.size();i++)
		{
			if(v.get(i).getDetails().getModelNo()==mobileModelNo)
			{
				return v.get(i);
			}
		}
		return null;
	}
	Mobile getMobile(String mobileName,String selName)
	{
		for(int i=0;i<v.size();i++)
		{
			if((v.get(i).getMobileName().equals(mobileName))&&(v.get(i).getSeller().getName().equals(selName)))
			{
				return v.get(i);
			}
		}
		return null;
	} 
	Mobile getMobile(String mobileName,String selName,int indexToStartFrom) throws IndexOutOfBoundsException
	{
		if(indexToStartFrom>=v.size())
		{
			throw  new IndexOutOfBoundsException();
		}
		for(int i=indexToStartFrom;i<v.size();i++)
		{
			if((v.get(i).getMobileName().equals(mobileName))&&(v.get(i).getSeller().getName().equals(selName)))
			{
				return v.get(i);
			}
		}
		return null;
	} 



	
	
	void displayMobiles()
	{
		for(int i=0;i<v.size();i++)
		{
			System.out.println(v.get(i));
		}
	}
	void displayMobiles(float lb,float ub) throws InvalidQuantityException
	{
		if(lb>ub)
			throw new InvalidQuantityException ("lower bound is greater than upper bound");
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getDetails().getPrice()>=lb&&v.get(i).getDetails().getPrice()<=ub)
				System.out.println(v.get(i));
		}
	}
	void displayMobiles(float lb,float ub,String compName)
	{
		
		for(int i=0;i<v.size();i++)
		{
			if(v.get(i).getDetails().getPrice()>=lb&&v.get(i).getDetails().getPrice()<=ub&&v.get(i).getDetails().getCompanyName().equals(compName))
				System.out.println(v.get(i));
		}
	}
	void displayMobiles(String compName)
	{
		Mobile m;
		for(int i=0;i<v.size();i++)
		{
			if((m=v.get(i)).getDetails().getCompanyName().equals(compName))
				System.out.println(m);
		}
	}
	void afterBilling(User u)
	{
		for(int i=0;i<u.getKart().getSize();i++)
		{
			String mobileName=u.getKart().getMobile(i).getMobileName();
			int quantity=u.getKart().getQuantity(i);
	
			while(quantity!=0)
			{	
				Mobile m=this.getMobile(mobileName);

				int q=m.getQuantity();
				if(q>quantity)
				{
					q=q-quantity;
					quantity=0;
					m.changeQuantity(u, q);
				}
				else
				{
					quantity-=q;
					v.remove(m);
				}
			}
		}
	}
}
