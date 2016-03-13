
public class InvalidQuantityException extends RuntimeException {

	String s;
	InvalidQuantityException(String message)
	{
		s=message;
	}
	InvalidQuantityException()
	{
		
	}
	public String toString()
	{
		return s!=null?s:"InvalidQuantityException";
	}
}
