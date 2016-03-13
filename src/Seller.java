import java.util.InputMismatchException;
import java.util.Scanner;


public class Seller extends Person {
	private int storeID;
	private String storeName;
	
	Seller()
	{
		ini();
	}
	Seller(String name)
	{
		super (name);
		ini();
	}
	void ini()
	{
		Scanner sc=new Scanner(System.in);

		do{
	 	
		try
		{
			System.out.println("enter storeid and storeName");
			storeID=sc.nextInt();
			break;
		}
		
		catch(InputMismatchException e)
			{
				System.out.println("wrong input.please retry");
				sc.next();
			}
		
	}while(true);
		storeName=sc.next();
		
	}
	int getStoreID()
	{
		return storeID;
	}
	String getStoreName()
	{
		return storeName;
	}
	
	void changeStoreName(User u,String n)
	{
		if(u.getRegister().getPassword().equals("admin"))
		{
			storeName=n;
		}
		else
		{
			System.out.println("you are not authorized to change the store Name");
		}
		
	}
	void changeStoreId(User u,int s)
	{
		if(u.getRegister().getPassword().equals("admin"))
		{
			storeID=s;
		}
		else
		{
			System.out.println("you are not authorized to change the store ID");
		}
		
	}
		public String toString()
	{
		return super.toString()+"Store id:"+storeID+"\n"+"store name:"+storeName;
	}

}
