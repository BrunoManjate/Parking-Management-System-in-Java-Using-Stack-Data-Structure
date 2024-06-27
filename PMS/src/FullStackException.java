import java.util.*;

public class FullStackException extends RuntimeException
{
	public FullStackException( )
	{
		super();
    }

	public FullStackException( String msg )
	{
		super(msg);
    }
}