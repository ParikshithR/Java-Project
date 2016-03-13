
import java.util.InputMismatchException;
import java.util.Scanner;

public class Specifications
{
	String clr,OS,CPU,sim;
	int memorySpace;
	float cameraMP,scrnSize;
	
	void ini()
	{ 
		Scanner sc=new Scanner(System.in);
			System.out.println("ENTER THE SPECIFICATIONS");
			
			System.out.println("Sim Type");
			sim=sc.next();
			
			System.out.println("Enter The Operating System You Need");
			OS=sc.next();
			
			System.out.println("Enter The Processor");
			CPU=sc.next();
			
			System.out.println("Enter The Colour of the Mobile");
			clr=sc.next();
			
			do{
				 	
					try
					{
						System.out.println("Enter The Camera MP");
						cameraMP=sc.nextFloat();
						
						System.out.println("Enter The Screen Size in Inches");
						scrnSize=sc.nextFloat();
						
						System.out.println("Enter The Memory Space in GB");
						memorySpace=sc.nextInt();
						break;

					}
					
					catch(InputMismatchException e)
						{
							System.out.println("wrong input.please retry");
							sc.next();
						}
				}while(true);
			
			
		
		
	}
	/*Specifications()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Specifications You Want");
		
		System.out.println("Enter the SIM Type single/dual sim");
		Sim=sc.next();
		
		System.out.println("Enter The Camera MP");
		Camera_MP=sc.nextInt();
		
		System.out.println("Enter The Screen Size in Inches");
		Scrn_Size=sc.nextInt();
		
		System.out.println("Enter The Memory Space in GB");
		Memory_Space=sc.nextInt();
		
		System.out.println("Enter The Operating System You Need");
		OS=sc.next();
		
		System.out.println("Enter The Processor");
		CPU=sc.next();
		
		System.out.println("Enter The Colour of the Mobile");
		Clr=sc.next();
	}*/
	Specifications()
	{
		ini();
	}
	public String toString()
	{
		return "\ncolour:\t"+clr+"\nOS:\t"+OS+"\nCPU:\t"+CPU+"\nCamera:\t"+cameraMP+"\nScreen size:\t"+scrnSize+"\nMemory space:\t"+memorySpace+"\nSim type:\t"+sim;
	}
	String getColour()
	{
		return clr;
	}
	String getOS()
	{
		return OS;
	}
	String getCPU()
	{
		return CPU;
	}
	String getSim()
	{
		return sim;
	}
	float getCamera()
	{
		return cameraMP;
	}
	float getScreenSize()
	{
		return scrnSize;
	}
	int getMemory()
	{
		return memorySpace;
	}
	void changeColour(User u,String s)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			clr=s;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
	void changeOS(User u,String s)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			OS=s;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
	void changeSim(User u,String s)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			sim=s;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
	void changeCPU(User u,String s)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			CPU=s;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
		void changeMemory(User u,int n)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			memorySpace=n;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
	void changeCameraMP(User u,float n)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			cameraMP=n;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
	void changeScreenSize(User u,float n)
	{
		if(u.getRegister().getUsername().equals("admin"))
		{
			scrnSize=n;
		}
		else
		{
			System.out.println("you are not authorized to change specs");
		}
	}
}