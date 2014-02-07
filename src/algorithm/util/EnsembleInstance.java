package algorithm.util;

import java.io.IOException;
import java.util.Vector;

import algorithm.functions.IEnsemble;

import classifier.model.EnsembleLearning;


public class EnsembleInstance implements IEnsemble {

    public EnsembleLearning instance;
	@Override
	public EnsembleLearning createAlgorithm(String resultFileName,
											Vector<Vector<String>> testSet,
											Vector<Vector<String>> A, 
											Vector<Vector<String>> B,
											Vector<Vector<String>> C, 
											Vector<Vector<String>> D,
											Vector<Vector<String>> E) throws IOException {

		return new EnsembleLearning(resultFileName, testSet, A, B, C, D, E);
	}

}
