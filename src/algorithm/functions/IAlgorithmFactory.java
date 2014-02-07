package algorithm.functions;

import java.util.Vector;


public interface IAlgorithmFactory
{
	 INaiveBayes getNaive();
	 IEnsemble   getEnsemble();
	 IEvaluation getEvaluator(String classifierModel, Vector<Vector<String>> actual, Vector<Vector<String>> predicted);
}
