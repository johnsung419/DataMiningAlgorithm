package algorithm.functions;

import general.function.FormatDecimal;
import general.function.PrintUtil;

import java.util.Vector;

import classifier.functions.ClassifierFactory;

public class AccuracyEvaluator
{
	
	public AccuracyEvaluator(String classifierModel, 
							Vector<Vector<String>> actual, 
							Vector<Vector<String>> predicted)
	{
		PrintUtil.getInstance().printLine( "Accuracy of " + classifierModel );
		PrintUtil.getInstance().printLine( 
										   "==>" + FormatDecimal.getInstance()
										   		   .performFormat(ClassifierFactory
										   				   		  .getInstance()
												   				  .getAccuracyInstance(actual, predicted)
												   				  ) );
	}
	
	
}
