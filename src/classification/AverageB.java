package classification;

import java.util.Vector;

public class AverageB
{
	private Vector<String> _average;
	
	public AverageB()
	{
		_average = new Vector<String>();
	}
	
	public AverageB(Vector<String> input)
	{
		_average = input;
	}
	
	public Vector<String> getAverage()
	{
		return _average;
	}
	
}
