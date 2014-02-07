package classification;

import java.util.Vector;

public class AverageM
{
	private Vector<String> _average;
	public AverageM()
	{
		_average = new Vector<String>();
	}
	
	public AverageM(Vector<String> input)
	{
		_average = input;
	}
	
	public Vector<String> getAverage()
	{
		return _average;
	}
	
}
