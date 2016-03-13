import java.util.InputMismatchException;
import java.util.Scanner;


abstract public class TestRun {
	static Scanner sc=new Scanner(System.in);
	static HasRegister hr=new HasRegister();
	static HasMobiles hm=new HasMobiles();
	static HasSeller hs=new HasSeller();
	static User u;
	
	
	static void deleteMobile()
	{
		outer:while(true)
		{	System.out.println("enter 1 :to delete mobiles of particular seller\nenter 2:"
					+ "to delete mobiles by mobile name\nenter 3:to delete mobile by mobile model no"
					+ "\nenter 4:to delete particular mobile of a particular seller"
					+ "\nenter 5:to go back to the previous page");
		
		 	
			try
			{	switch(sc.nextInt())
				{
				case 1: System.out.println("enter seller name");
						hm.deleteMobileS(u,sc.next());
						break ;
				case 2:System.out.println("enter mobile name");
						hm.deleteMobile(u,sc.next());
						break ;
				case 3:
						System.out.println("enter mobile model no");
						hm.deleteMobile(u,sc.nextInt());
						break ;
				case 4:
						System.out.println("enter mobile name and seller name");
						hm.deleteMobile(u,sc.next(),sc.next());
						break ;
				case 5:
						break outer;
				default:
						System.out.println("invalid input");
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("wrong input.please retry");
				sc.next();
			}
			
	
	}
	}
	static void changeMobile()
	{
		outer: while(true){
							try
							{
								System.out.println("enter 1: to change mobile name\nenter 2:to change quantity\nenter 3:"
											+ "to change seller\nenter 4:to go back to the previous page");
									switch(sc.nextInt())
									{
									case 1: System.out.println("enter mobile whose name has to be changedand new name");
											Mobile m=hm.getMobile(sc.next());
											if(m!=null)
											m.changemobileName(u, sc.next());
											else
												System.out.println("mobile does not exists");
											break ;
									case 2:System.out.println("enter mobile name,corresponding seller name and new quantity");
											Mobile m1=hm.getMobile(sc.next(),sc.next());
											if(m1!=null)
												m1.changeQuantity(u, sc.nextInt());
											else
												System.out.println("mobile does not exists");	
											break ;
									case 3: System.out.println("enter mobile name,seller and new seller name");
											Mobile m2=hm.getMobile(sc.next(), sc.next());
											if(m2==null)
											{
												System.out.println("mobile does not exist");
												break ;
											}
											else
											{
												Seller s=hs.getSeller(sc.next());
												if(s!=null)
													m2.changeSeller(u, s);
												else
													System.out.println("seller does not exist");
												break ;
											}
									case 4:
											break outer;
									default :
											System.out.println("invalid input");
									}
										
								}
									
								catch(InputMismatchException e)
									{
										System.out.println("wrong input.please retry");
										sc.next();
									}
		}
	}
	
	static void addSeller()
	{
		hs.addSeller(u);
	}
	static void changeSeller()
	{
		System.out.println("enter name of the seller and new name ");
		Seller s=hs.getSeller(sc.next());
		String newName=sc.next();
		if(s!=null)
		{
			s.changeName(newName);
		}
		else
		{
			System.out.println("seller does not exists");
		}
	}
	
	static int logOut()
	{
		
		do{
			 	
				try
				{
					System.out.println("are you sure you want to log out:if yes press 1");
					if(sc.nextInt()==1)
					{
						u=null;
						return 1;
					}
					return 0;
				}
				
				catch(InputMismatchException e)
				{
						System.out.println("wrong input.please retry");
						sc.next();
				}
		}while(true);
		
	}

	static void viewMobile()
	{
		outer:while(true)
			{System.out.println("enter 1:to view all mobiles in the store\nenter 2:to add filters\nenter 3:to go back to the previous page");
				try
				{
						switch(sc.nextInt())
					
					{
					case 1:
							hm.displayMobiles();
							break ;
					case 2:
							inner:while(true)
							{
								System.out.println("enter 1:to view mobiles between a particular range\n"
							
											+ "enter 2:to view mobiles between a particular range + particular company"
											+ "\nenter 3:to view mobiles of a particular company\nenter 4:to go back to the previous page");
									switch(sc.nextInt())
									{
									case 1:
											while(true){
											System.out.println("enter lower bound");
											float a=sc.nextFloat();
											System.out.println("enter upper bound");
											float b=sc.nextFloat();
											try{
													hm.displayMobiles(a, b);
													break;
													}
													catch(InvalidQuantityException e)
													{
														System.out.println(e);
													}
											}
										
											break ;
									case 2:
					
										System.out.println("enter lower bound");
										float a1=sc.nextFloat();
										System.out.println("enter upper bound");
										float b1=sc.nextFloat();
										System.out.println("enter company name");
										hm.displayMobiles(a1, b1, sc.next());
										break ;
									case 3:
										System.out.println("enter company name");
										hm.displayMobiles(sc.next());
										break ;
									case 4:
										break inner;
									default:
										System.out.println("invalid input");
										
									}	
							}
							break ;
					case 3:
							break outer;
					default :
							System.out.println("invalid input");
				
			
					}
						
				}
				catch(InputMismatchException e)
				{
					System.out.println("wrong input format");
					sc.next();
				}
			}
	}
	static void Register()
	{
		hr.addRegister();
		
	}
	static void logIN()
	{
		int n;
	
		System.out.println("please log in");
		outer :while(true)
		{	System.out.println("enter username:");
			String u=sc.next();
			System.out.println("enter password");
			String p=sc.next();
			if(hr.registerExists(u,p))
			{
				TestRun.createUser(hr.getRegister(u, p));
				break;
			}
			else
			{
				System.out.println("wrong password or username");
				while(true)
				{	try{
					System.out.println("enter 1 to register\nenter2: to retry\nenter 3 to go back to the previous page");
					n=sc.nextInt();
					if(n==1)
					{
						TestRun.Register();
						break outer;
					}
					if(n==3)
					{
						break outer;
					}
					if(n==2)
					{
						break;
					}
					System.out.println("invalid input.try again");
					}
					catch(InputMismatchException e)
					{
						System.out.println("wrong input format.please retry");
						sc.next();
					}
				}
			}
		}
	}
	
	static void createUser(Register r)
	{
		u=new User(r);
		hr.loginCheck(u);
		menuLogedIn();
	}
	static void mainMenu()
	{
		while(true)
		{	System.out.println("enter 1:to register\nenter 2:to log in\n3:to view mobiles\nenter 4:to exit the store");
			try{
			switch(sc.nextInt())
			{
			case 1:
					TestRun.Register();
					break;
			case 2: TestRun.logIN();
					break;
			case 3:
				TestRun.viewMobile();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("invalid input");
	
			}
			}
			catch(InputMismatchException e)
			{
				System.out.println("wrong input format.try again");
				sc.next();
			}
		}
			
	
	}
	static void addCart()
	{
		Mobile m;
		int q;
		outer:while(true)
		{
			System.out.println("enter mobile name");
			String n=sc.next();
			 m=hm.getMobile(n);
			if(m==null)
					System.out.println("mobile does not exist.try again");
			else
				{
				
						inner:while(true)
						{
							System.out.println("enter quantity");
							try
							{
								q=sc.nextInt();
								if(q<1)
									throw new InvalidQuantityException("entered quantity is less than 1");
								if(q>hm.getMobileQuantity(n))
								{
									System.out.println("entered quantity is more than the available stock");
									continue ;
								}
								break ;
							}
							catch(InvalidQuantityException e)
							{
								System.out.println(e);
								sc.next();
								continue ;
							}
							catch(InputMismatchException e)
							{
								System.out.println(e);
								sc.next();
								continue;
							}
							
						}
						u.getKart().addMobile(m,q);
				}
			while(true)
			{	System.out.println("enter 1 to go back to the previous page");
				try
				{
					if(sc.nextInt()==1)
						break outer;
					else
						break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("wrong input type.try again");
					sc.next();
				}
			}

		}
		
	}
	static void changeUserDetails()
	{
		outer:while(true)
		{		System.out.println("enter 1:to change username\nenter 2:to change password\n"
						+ "enter 3:to change Name\nenter 4:to change age\nenter 5:to go back to the previous page");
				
			try
			{	switch(sc.nextInt())
				{
				case 1:
						while(true)
						{	System.out.println("enter new username");
						String newUserName=sc.next();
						if(!hr.registerExists(newUserName))
						{
							u.getRegister().changeUserName(newUserName);
							break;
						}
						else
						{
							System.out.println("username already exist");
						}
						}
						break;
				case 2:
						while(true){
						System.out.println("enter current password");
						String p=sc.next();
						if(p.equals(u.getRegister().getPassword()))
						{
							System.out.println("enter new password");
							String newPassword=sc.next();
							u.getRegister().changePassword(newPassword);
							break;
						}
						else
						{
							System.out.println("you have entered wrong password");
						}
						}
						break;
				case 3:
					System.out.println("enter new Name");
					u.getRegister().changeName(sc.next());
					break;
						
				case 4:
					System.out.println("enter new age");
					u.getRegister().changeAge(sc.nextInt());
					break;
				case 5:
					break outer;
				default:
					System.out.println("invalid input");
						
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("wrong input format.try again");
				sc.next();
			}
		}
	}
	static int billing()
	{
		while(true)
		{
			try
			{
				if(u.getKart().getSize()==0)
				{
					System.out.println("cart does not consist any mobile.please add mobiles to cart first");
					return 1;
				}
				System.out.println("enter payment option:\n1 for cash on delivery\n2 for card payment");
				int q=sc.nextInt();
				if(q==1||q==2)
					u.getKart().paymentOption(q);
				else
					throw new InvalidQuantityException("enter either 1 or 2");
				System.out.println("\t***********BILL***********\t");
				u.getKart().displayMobile();
				System.out.println("\n\n\t\tTOTAL AMOUNT:\t"+u.getKart().totalAmount());
				System.out.println("\n\nenter 1:to confirm order\nenter 2:to cancel the order");
				if(sc.nextInt()==1)
				{
					System.out.println("\n\nTHANK YOU :D");
					u.bill=1;
					hm.afterBilling(u);
					u.bill=0;
					u.getKart().clearKart();
				}
				else
				{
					System.out.println("do you want to continue shopping:enter Y/N");
					if(sc.next().equals("y"))
					{
						return 1;
					}
					else
						return 0;
				}
				System.out.println("do you want to continue shopping:enter Y/N");
				if(sc.next().equals("y"))
				{
					return 1;
				}
				else
					return 0;
				
			}
			catch(InputMismatchException e)
			{
				System.out.println(e);
				sc.next();
			}
			catch(InvalidQuantityException e)
			{
				System.out.println(e);
			}
		}
	}
	
	static void menuLogedIn()
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			outer:while(true){
								System.out.println("enter 1:to add mobile\nenter 2 :to delete mobile"
										+ "\nenter 3:to change mobile details\nenter 4:to remove user"
										+ "\nenter 5:to add seller\nenter 6:to remove seller\nenter 7:to change seller details"
										+ "\nenter 8:to view mobiles\nenter 9:to view sellers"
										+ "\nenter 10:to log out");		
							try{	switch(sc.nextInt())
								
									{
							
									case 1:
										hm.createMobile(u,hs);
											break ;
									case 2:
											deleteMobile();
											break;
									case 3:
											changeMobile();
											break ;
									case 4:
						
										hr.removeRegister(u);
										
											break ;
									case 5:
										hs.addSeller(u);
										break;
									case 6:
						
										System.out.println("enter seller name");
										String s=sc.next();
										hs.removeSeller(u,s,hm);
										break ; 
									case 7:
						
										changeSeller();
										break ;
									case 8:TestRun.viewMobile();
											break;
									case 9:
											hs.displaySeller();
											break;
										
									case 10:
											if(TestRun.logOut()==1)
											break outer;
											else
												break;
									default:System.out.println("invalid input");
									}
							}
							catch(InputMismatchException e)
							{
								System.out.println(e);
								sc.next();
							}
					 }
		}
		
		else
		{
			outer :while(true){
								System.out.println("enter 1:to view mobiles\nenter 2:to add mobile in the cart\nenter 3:to "
										+ "change your personal details\nenter 4:to proceed for billing"
										+ "\nenter 5:to log out");
								try{
										switch(sc.nextInt())
										{
										case 1:
												TestRun.viewMobile();
												break;
										case 2:
												TestRun.addCart();
												break;
										case 3:
												TestRun.changeUserDetails();
												break;
										case 4:
											if(TestRun.billing()==1)
												break;
											else
												if(TestRun.logOut()==1)
													break outer;
												else
													break;
										case 5:
											if(TestRun.logOut()==1)
											break outer;
											else
												break;
										default:
											System.out.println("invalid");
											
										}
								}
								catch(InputMismatchException e)
								{
									System.out.println("wrong input type.please retry");
									sc.next();
								}
					}
		}

	}
	
	public static void main(String [] arg)
	{
		
		System.out.println("WELCOME TO THE MOBILE STORE");
		TestRun.mainMenu();
	}

}
