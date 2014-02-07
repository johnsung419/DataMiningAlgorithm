package algorithm.functions;


import java.io.IOException;
import java.util.Vector;

import classifier.model.NaiveBayesAlgorithm;


public interface INaiveBayes 
{
	NaiveBayesAlgorithm createAlgorithm(String fileName, Vector<Vector<String>> objects, Vector<Vector<String>> tests) throws IOException;
	
}
