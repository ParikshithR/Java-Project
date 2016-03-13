import java.util.InputMismatchException;
import java.util.Scanner;


public interface PaymentOption {
	
	void get();
	

}

class Card implements PaymentOption 
{
	String cardName,address;
	int expiry_date,cvv_no;
	Card()
	{
		get();
	}
	public void get()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your card name");
		cardName=sc.next();
		do{
		 	
			try
			{

				System.out.println("Enter expiry date");
				expiry_date=sc.nextInt();
				System.out.println("Enter your CVV no.");
				cvv_no=sc.nextInt();
				break;

			}
			
			catch(InputMismatchException e)
				{
					System.out.println("wrong input.please retry");
					sc.next();
				}
			
		}while(true);
		System.out.println("Enter address");
		address=sc.nextLine();
	}
	public String toString()
	{
		return "card name:"+cardName+"\nExpiry date"+expiry_date+"\ncvv_no"+cvv_no+"\nAddress of the customer is: "+address;
	}
}

class Cash implements PaymentOption
{
	String address;
	Cash()
	{
		get();
	}
	public void get()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter address");
		address=sc.nextLine();
	}
	public String toString()
	{
		return "Address of the customer is: "+address;
	}
}

/*class Demo1
{
	public static void main(String []args)
	{
		int ch;
		Scanner sc=new Scanner(System.in);
		System.out.println("How would you like to pay");
		System.out.println("1:Card or 2:Cash");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:Card c1=new Card();
		c1.get();
		c1.display();
		break;
		case 2:Cash c2=new Cash();
		c2.get();						//will take price from details
		c2.display();
		}
	}
}*/