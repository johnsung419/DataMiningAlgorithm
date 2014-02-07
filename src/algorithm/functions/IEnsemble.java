package algorithm.functions;

import java.io.IOException;
import java.util.Vector;

import classifier.model.EnsembleLearning;



public interface IEnsemble
{
	EnsembleLearning createAlgorithm(String resultFileName,
									 Vector<Vector<String>> testSet,
									 Vector<Vector<String>> A,
									 Vector<Vector<String>> B,
									 Vector<Vector<String>> C,
									 Vector<Vector<String>> D,
									 Vector<Vector<String>> E) throws IOException;
	
}
