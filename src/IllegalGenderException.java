
public class IllegalGenderException extends RuntimeException{
	String s;
	IllegalGenderException()
	{
	}
	IllegalGenderException(String message)
	{
		s=message;
	}
	public String toString()
	{
		return	s!=null?s:"enter either male or female";
	}
}
