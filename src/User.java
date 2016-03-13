
public class User {
	private Kart k=new Kart();
	private Register r;
	int bill=0;
	User(Register r)
	{
		this.r=r;
	}
	Register getRegister()
	{
		return r;
	}
	Kart getKart()
	{
		return k;
	}
	
	

}
