package general.function;

public class PrintUtil
{
	
	public static PrintUtil instance;
	private PrintUtil() {}
	
	public static PrintUtil getInstance()
	{
		if(instance == null)
			instance = new PrintUtil();
		
		return instance;
	}
	public void printLine(String input)
	{
		System.out.println(input);
	}
	
	public void printBlankLine()
	{
		System.out.println();
	}
	
}
