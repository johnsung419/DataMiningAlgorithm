package classifier.util;

import general.function.PosteriorProbability;

import java.util.Vector;

import classification.AverageB;
import classification.AverageM;
import classification.StandardDeviationB;
import classification.StandardDeviationM;
import classifier.functions.IProcessClassification;

public class ProcessClassification implements IProcessClassification
{
	private Vector<Vector<String>> _classifiedSet;
	
	public ProcessClassification(Vector<Vector<String>> testSet,
								 AverageB averageB, 
								 AverageM averageM, 
								 StandardDeviationB stdevB,
								 StandardDeviationM stdevM) 
	{
		_classifiedSet = new Vector<Vector<String>>( testSet ); 
		
		Vector<String> avgB = averageB.getAverage();
		Vector<String> avgM = averageM.getAverage();
		Vector<String> stdB = stdevB.getStandardDeviation();
		Vector<String> stdM = stdevM.getStandardDeviation();
		
		for(int i = 0; i < testSet.size(); i++)
		{
			double [] posteriorB = new double[avgB.size()];
			double [] posteriorM = new double[avgM.size()];
			double productB = 1.0;
			double productM = 1.0;
			
			Vector<String> element = testSet.get(i);
			for(int j = 0; j < element.size() ; j++)
			{
				posteriorB[j] = PosteriorProbability.getInstance().computeProbability(element.get(j),  avgB.get(j), stdB.get(j));
				posteriorM[j] = PosteriorProbability.getInstance().computeProbability(element.get(j),  avgM.get(j), stdM.get(j));
				
			}
			
			for(double each: posteriorB)
			{
				productB = productB * each;
			}
			
			for(double each: posteriorM)
			{
				productM = productM * each;
			}
			
			if( productB >= productM)
			{
				element.add(0, "B");
			}
			else
			{
				element.add(0, "M");
			}
		}	
	}
	
	public Vector<Vector<String>> getClassifiedSet()
	{
		return _classifiedSet;
	}
	

}
