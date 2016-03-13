import java.util.InputMismatchException;
import java.util.Scanner;

public class Details {
	String companyName,yearRelease;
	float price;
	int modelNo;
	static Scanner sc=new Scanner(System.in);
	
	void ini()
	{ 
		Scanner sc=new Scanner(System.in);
		while(true){
		try{
		    System.out.println("ENTER THE NEW MOBILE DETAILS");
		    System.out.println("Enter the price");
	    	price=sc.nextFloat();
	    	if(price<0)
	    		throw new InvalidQuantityException("price cannot be less than 0 :)");
	    	
		    System.out.println("Enter the Company Name");
	    	companyName=sc.next();
	    	
	    	System.out.println("Enter the Model Number");
	    	modelNo=sc.nextInt();
	    	System.out.println("Enter the Year Of Release Of The Mobile");
	    	yearRelease=sc.next();
	    	break;
		}
		catch(InputMismatchException e)
		{
			System.out.println("wrong input type.please retry");
			sc.next();
		}
	    catch(InvalidQuantityException e)
		{
	    	System.out.println(e);
	    	
	    }}
	}
/*    Details()
    {
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter the Company Name");
    	Company_Name=sc.next();
    	
    	System.out.println("Enter the Model Number");
    	Model_No=sc.next();
    	
    	System.out.println("Enter the Year Of Release Of The Mobile");
    	Year_Release=sc.next();
    	
    	System.out.println("Do you want mobile of a specific seller\n If yes press 1                                              else press 2");

    	int choice=sc.nextInt();
    	
    	if(choice==1)
    	{
    		System.out.println("Enter the Seller ID");
    		int s_id=sc.nextInt();
    	}
    	
    }
*/
	Details()
	{
		ini();
	}
	String getCompanyName()
	{
		return companyName;
	}
	float getPrice()
	{
		return price;
	}
	int getModelNo()
	{
		return modelNo;
	}
	String getYearRelease()
	{
		return yearRelease;
	}
	void changeCompanyName(User u)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			System.out.println("enter company name");
			companyName=sc.next();	
		}
	}
	void changePrice(User u)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{while(true){
			try{
			System.out.println("enter new price");
			price=sc.nextFloat();
			if(price<0)
				throw new InvalidQuantityException("price cannot be less than zero");
			break;
			}
			
			catch(InputMismatchException e)
			{
				System.out.println("wrong input type.please retry");
				sc.next();
			}
			catch(InvalidQuantityException e)
			{
				System.out.println(e);
				
			}
		}
		}
	}
	
	void changeModelNo(User u)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			while(true){
			try{
			System.out.println("enter new model no");
			modelNo=sc.nextInt();
			break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("wrong input type.please retry");
				sc.next();
			}
			}
		}
	}
	void changeYearRelease(User u)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			while(true){
				try{System.out.println("enter new year of release");
				yearRelease=sc.next();	
				break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("wrong input type.please retry");
					sc.next();
				}
				}
		}
	}
	public String toString()
	{
		return "\nmodel no:\t"+modelNo+"\ncompany name:\t"+companyName+"\nPrice:\t"+price+"\nyear of release:\t"+yearRelease;
	}
	
}
