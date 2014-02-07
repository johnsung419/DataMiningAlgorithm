package algorithm.functions;

import java.util.Vector;

public interface IComputeAccuracy 
{
	public double process(Vector<Vector<String>> actual, Vector<Vector<String>> predicted);
	
}
