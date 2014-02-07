package algorithm.util;

import java.util.Vector;

import algorithm.functions.IComputeAccuracy;


public class ComputeAccuracy implements IComputeAccuracy
{
	public static ComputeAccuracy instance;
	public ComputeAccuracy()
	{		
	}
	
	public ComputeAccuracy getInstance()
	{
		if(instance == null)
			instance = new ComputeAccuracy();
		
		return instance;
	}
	
	
	@Override
	public double process( Vector<Vector<String>> actual,
								Vector<Vector<String>> predicted)
	{
		double TP = 0.0;
		double FN = 0.0;
		double FP = 0.0;
		double TN = 0.0;
		
		for(int i = 0; i < actual.size(); i++)
		{
			Vector<String> col = actual.get(i);
			Vector<String> col2 = predicted.get(i);
			if(col.get(1).equalsIgnoreCase("B") && col2.get(1).equalsIgnoreCase("B"))
			{
				TP++;
			}
			else if(col.get(1).equalsIgnoreCase("B") && col2.get(1).equalsIgnoreCase("M"))
			{
				FN++;
			}
			else if(col.get(1).equalsIgnoreCase("M") && col2.get(1).equalsIgnoreCase("B"))
			{
				FP++;
			}
			else//  M   M
			{
				TN++;
			}
			
		}
		
		return (TP + TN) / (TP + FN + FP + TN);
		
	}
	

}
