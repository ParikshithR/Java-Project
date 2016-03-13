import java.util.Vector;


public class Kart {
	private Vector <Mobile> v=new Vector<Mobile>();
	 private int [] quantity=new int [100];
	static int Q_ARRAY_COUNT=0;
	PaymentOption p;
	void addMobile(Mobile m,int quntity)
	{
		v.add(m);
		quantity[Kart.Q_ARRAY_COUNT++]=quntity;
		
	}
	void clearKart()
	{
		v.removeAllElements();
		Q_ARRAY_COUNT=0;
		
	}
	int getSize()
	{
		return v.size();
	}
	int getQuantity(int index) throws IndexOutOfBoundsException
	{
		if(index>Q_ARRAY_COUNT)
		{
			throw new IndexOutOfBoundsException("index greater than the elements in the array");
		}
		return quantity[index];
	}
	Mobile getMobile(int index)
	{
		if(index>=v.size())
		{
			throw new IndexOutOfBoundsException("index greater than the elements in the array");
		}
		else
			return v.elementAt(index);
		
	}
	void displayMobile()
	{
		System.out.println("NAME:"+"\t\tQUANTITY"+"\t\tPRICE");
		for(int i=0;i<v.size();i++)
		{
			System.out.println(v.get(i).getMobileName()+"\t\t"+quantity[i]+"\t\t"+v.get(i).getDetails().price);
		}
	}
	void paymentOption(int i)
	{
		if(i==1)
			p=new Cash();
		else
			p=new Card();
	}
	double totalAmount()
	{
		double sum=0;
		for(int i=0;i<v.size();i++)
		{
			double s1=v.get(i).getDetails().price;
		
			s1=s1*quantity[i];
			sum+=s1;
		}
		return sum;
	}
	
	
	

}
