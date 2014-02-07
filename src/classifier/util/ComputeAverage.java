package classifier.util;

import general.function.CopyVector;
import general.function.FormatDecimal;

import java.util.Vector;

import classification.AverageB;
import classification.AverageM;
import classifier.functions.IComputeAverage;

public class ComputeAverage implements IComputeAverage 
{
	
	public ComputeAverage(Vector<Vector<String>> input, AverageB B, AverageM M)
	{
		double [] averageB = new double[input.get(0).size() - 1];
		double [] averageM = new double[input.get(0).size() - 1];
		
		Vector<String> avgB = B.getAverage();
		Vector<String> avgM = M.getAverage();
		
		int numBs = 0;
		int numMs = 0;
		
		Vector<Vector<String>> inputMatrix = CopyVector.getInstance().performCopy( input );
		
		for(int i = 0; i < inputMatrix.size(); i++)
		{
			Vector<String> element = inputMatrix.get(i);
			if(inputMatrix.get(i).get(0).equalsIgnoreCase("B"))
			{		
				int index = 0;
				for(int j = 1; j < element.size() ; j++)
				{
					averageB[index] = averageB[index] + Double.parseDouble( element.get(j) );
					index++;
				}
				numBs++;
			}
			else// "M"
			{
				int index2 = 0;
				for(int j = 1; j < element.size() ; j++)
				{
					averageM[index2] = averageM[index2] + Double.parseDouble( element.get(j) );
					index2++;
				}
				numMs++;
			}
		}
		
		for(double eachAverage: averageB)
		{
		    double avg = eachAverage / numBs;
		    avgB.add( FormatDecimal.getInstance().performFormat(avg)  );
		    
		}
		
		for(double eachAverage: averageM)
		{
		    double avg = eachAverage / numMs;
		    
		    avgM.add( FormatDecimal.getInstance().performFormat(avg)  );

		}	

	}
}
