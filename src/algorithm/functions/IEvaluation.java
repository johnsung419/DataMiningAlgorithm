package algorithm.functions;

import java.util.Vector;


public interface IEvaluation
{
     AccuracyEvaluator createInstance(String classifierModel, Vector<Vector<String>> actual, Vector<Vector<String>> predicted);
}
