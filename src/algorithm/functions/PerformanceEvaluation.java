package algorithm.functions;

import java.util.Vector;




public class PerformanceEvaluation implements IEvaluation 
{
	public PerformanceEvaluation(String classifierModel, 
								 Vector<Vector<String>> actual, 
								 Vector<Vector<String>> predicted)
	{
		createInstance(classifierModel, actual, predicted);
	}
	
	
	@Override
	public AccuracyEvaluator createInstance(String classifierModel, 
											Vector<Vector<String>> actual, 
											Vector<Vector<String>> predicted)
	{
		return new AccuracyEvaluator(classifierModel, actual, predicted);
	}

	
}
