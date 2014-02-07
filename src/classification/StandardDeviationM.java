package classification;

import java.util.Vector;

public class StandardDeviationM
{
	private Vector<String> _stdev;

	public StandardDeviationM()
	{
		_stdev = new Vector<String>();
	}

	public StandardDeviationM(Vector<String> input)
	{
		_stdev = input;
	}

	public Vector<String> getStandardDeviation()
	{
		return _stdev;
	}

}
