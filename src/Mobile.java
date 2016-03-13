
import java.util.Scanner;
import java.lang.String;
public class Mobile {
	private String mobileName;
	private Details d;
	private Specifications sp;
	private Seller s;
	private int quantity;
	Mobile(Seller sellerName,int q,String mobileName)
	{
		this.mobileName=mobileName;
		d=new Details();
		sp=new Specifications();
		
		quantity=q;
		s=sellerName;
	}
	String getMobileName()
	{
		return mobileName;
	}
	Details getDetails()
	{
		return d;
	}
	Specifications getSpecs()
	{
		return sp;
	}
	
	Seller getSeller()
	{
		return s;
	}
	int getQuantity()
	{
		return quantity;
	}
	void changemobileName(User u,String n)
	{
		if(u.getRegister().getUsername().equals("admin"))
			mobileName=n;
		else
			System.out.println("you are not authorized to change the quantity");
	}
	void changeQuantity(User u,int q)
	{
		if(u.getRegister().getUsername().equals("admin")||u.bill==1)
		quantity=q;
		else
			System.out.println("you are not authorized to change the quantity");
	}
	void addQuantity(User u,int q)
	{
		if(u.getRegister().getUsername().equals("admin"))
		quantity+=q;
		else
			System.out.println("you are not authorized to change the quantity");
	}
	void changeSpecs(User u)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			sp=new Specifications();
		}
		else
		{
			System.out.println("you are not authorized to change mobile specs");
		}
	}
	void changeDetails(User u)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			d=new Details();
		}
		else
		{
			System.out.println("you are not authorized to change mobile Details");
		}
	}
	void changeSeller(User u,Seller se)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			s=se;
		}
		else
		{
			System.out.println("you are not authorized to change mobile seller");
		}
	}
	public String toString()
	{
		return "\n*************************\nmobile name:\t"+mobileName+"\ndetails:"+d.toString()+"\nspecs:"+sp.toString()+"\nquantity:\t"+quantity+"\nseller:\n"+s+"\n******************************************\n" ;
	}
	
}
