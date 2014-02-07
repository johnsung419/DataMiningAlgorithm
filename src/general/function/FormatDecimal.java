package general.function;

import java.text.DecimalFormat;

public class FormatDecimal 
{
	public static FormatDecimal instance;
	private DecimalFormat _formatter;

	private FormatDecimal()
	{
		_formatter = new DecimalFormat("#0.0000");	
	}
	
	public static FormatDecimal getInstance()
	{
		if(instance == null)
			instance = new FormatDecimal();
		
		return instance;
	}
	
	public String performFormat(double number)
	{		
		return _formatter.format(number);
	}

}
