package classifier.functions;

import java.util.Vector;

import util.FileGenerator;

import classification.AverageB;
import classification.AverageM;
import classification.StandardDeviationB;
import classification.StandardDeviationM;

public interface IClassifierFactory
{
     INaiveBayesClassifier getNewNaiveBayesClassifier(Vector<Vector<String>> inputMatrix);
     IComputeAverage computeAverage(Vector<Vector<String>> input, AverageB averageB, AverageM averageM);
     IComputeStandardDeviation computeStandardDeviation(Vector<Vector<String>> inputMatrix,  AverageB averageB, AverageM averageM, StandardDeviationB stdevB, StandardDeviationM stdevM);
     IProcessObject processObject();
     IProcessClassification classify(Vector<Vector<String>> testSet, AverageB averageB, AverageM averageM, StandardDeviationB stdevB, StandardDeviationM stdevM);
     FileGenerator TestSetFileInstance();
     FileGenerator TrainingSetFileInstance();
     IProcessInput processInput();
     ISupportClassifier selectClassifier();
     IEnsembleLearningUtil launchUtil();
 	 double getAccuracyInstance(Vector<Vector<String>> actual, Vector<Vector<String>> predicted);

}
