package classifier.util;

import general.function.CopyVector;
import general.function.FormatDecimal;

import java.util.Vector;

import classification.AverageB;
import classification.AverageM;
import classification.StandardDeviationB;
import classification.StandardDeviationM;
import classifier.functions.IComputeStandardDeviation;

public class ComputeStandardDeviation implements IComputeStandardDeviation
{
	
	public ComputeStandardDeviation(Vector<Vector<String>> input,
									AverageB averageB,
									AverageM averageM, 
								    StandardDeviationB stdevB,
								    StandardDeviationM stdevM) 
	{
		Vector<String> avgB = averageB.getAverage();
		Vector<String> avgM = averageM.getAverage();
		
		Vector<String> stdB = stdevB.getStandardDeviation();
		Vector<String> stdM = stdevM.getStandardDeviation();
		
		int numBs = 0;
		int numMs = 0;
		double [] eachRowB = new double[input.get(0).size() - 1];
		double [] eachRowM = new double[input.get(0).size() - 1];

		Vector<Vector<String>> inputMatrix = CopyVector.getInstance().performCopy(input);
		
		for(int i = 0; i < inputMatrix.size(); i++)
		{
			Vector<String> element = inputMatrix.get(i);
			if(inputMatrix.get(i).get(0).equalsIgnoreCase("B"))
			{		
				int index = 0;
				for(int j = 1; j < element.size() ; j++)
				{
					eachRowB[index] = eachRowB[index] +  Math.pow( 
													     Math.abs( Double.parseDouble(  element.get(j) ) - Double.parseDouble( avgB.elementAt( index ) ) ) 
													     , 2 
													     );
					index++;
				}
				numBs++;
			}
			else// "M"
			{
				int index2 = 0;
				for(int j = 1; j < element.size() ; j++)
				{
					eachRowM[index2] = eachRowM[index2] +  Math.pow( 
						     							   Math.abs( Double.parseDouble(  element.get(j) ) - Double.parseDouble( avgM.elementAt( index2 ) ) ) 
						     							   , 2 
						     							   );
					index2++;
				}
				numMs++;

			}
		}
		
		for(double each : eachRowB)
		{
		    double std = Math.sqrt( each / numBs);
		    stdB.add( FormatDecimal.getInstance().performFormat( std ) );
		}
		
		for(double each: eachRowM)
		{
		    double std = Math.sqrt( each / numMs);
		    stdM.add( FormatDecimal.getInstance().performFormat( std ) );
		}
		
		

	}
}
