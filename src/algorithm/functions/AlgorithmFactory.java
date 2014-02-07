package algorithm.functions;

import java.util.Vector;

import algorithm.util.EnsembleInstance;
import algorithm.util.NaiveInstance;


public class AlgorithmFactory implements IAlgorithmFactory{

	public static AlgorithmFactory instance;
	
	public static IAlgorithmFactory getInstance()
	{
		if(instance == null)
		{
			instance = new AlgorithmFactory();
		}
		
		return instance;
	}
	
	@Override
	public INaiveBayes getNaive()
	{
		
		return new NaiveInstance();
	}

	@Override
	public IEnsemble getEnsemble()
	{

		return new EnsembleInstance();
	}
	

	@Override
	public IEvaluation getEvaluator(String classifierModel, Vector<Vector<String>> actual, Vector<Vector<String>> predicted)
	{

		return new PerformanceEvaluation(classifierModel, actual, predicted);
	}

}
