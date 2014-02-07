package algorithm.util;

import java.io.IOException;
import java.util.Vector;

import algorithm.functions.INaiveBayes;

import classifier.model.NaiveBayesAlgorithm;


public class NaiveInstance implements INaiveBayes {

	
	@Override
	public NaiveBayesAlgorithm createAlgorithm(String fileName, 
											   Vector<Vector<String>> objects,
											   Vector<Vector<String>> tests)
											   throws IOException {

		return new NaiveBayesAlgorithm(fileName, objects, tests);
	}

}
