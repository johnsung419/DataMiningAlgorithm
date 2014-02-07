package classification;

import java.util.Vector;

public class StandardDeviationB 
{
    private Vector<String> _stdev;
	
	public StandardDeviationB()
	{
		_stdev = new Vector<String>();
	}
	
	public StandardDeviationB(Vector<String> input)
	{
		_stdev = input;
	}
	
	public Vector<String> getStandardDeviation()
	{
		return _stdev;
	}

}
