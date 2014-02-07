package classifier.functions;

import java.util.Vector;

import algorithm.util.ComputeAccuracy;

import util.FileGenerator;
import util.TestFile;
import util.TrainingFile;

import classification.AverageB;
import classification.AverageM;
import classification.StandardDeviationB;
import classification.StandardDeviationM;
import classifier.util.ComputeAverage;
import classifier.util.ComputeStandardDeviation;
import classifier.util.LaunchUtil;
import classifier.util.ProcessClassification;
import classifier.util.ProcessInput;
import classifier.util.ProcessObject;
import classifier.util.SupportClassifier;


public class ClassifierFactory implements IClassifierFactory
{
	public static ClassifierFactory instance;
	
	public static ClassifierType classifiers;
	
	private ClassifierFactory() {}
	public enum ClassifierType
	{
		NaiveBayes,
		ConjunctiveRule,
		DecisionTree,
		LogisticRegression,
		RandomTree,
		EnsembleApproach
	};
	
	
	public static IClassifierFactory getInstance()
	{
		if(instance == null)
		{
			instance = new ClassifierFactory();
		}
		
		return instance;
	}
	
	@Override
	public INaiveBayesClassifier getNewNaiveBayesClassifier(Vector<Vector<String>> inputMatrix) 
	{
		return null;
	}

	@Override
	public IComputeAverage computeAverage(Vector<Vector<String>> input, AverageB averageB, AverageM averageM)
	{	
		return new ComputeAverage(input, averageB, averageM);
	}

	@Override
	public IComputeStandardDeviation computeStandardDeviation(Vector<Vector<String>> inputMatrix, 
															  AverageB averageB, 
															  AverageM averageM,
															  StandardDeviationB stdevB,
															  StandardDeviationM stdevM)
	{
		return new ComputeStandardDeviation(inputMatrix, averageB, averageM, stdevB, stdevM);
	}

	@Override
	public IProcessObject processObject() 
	{
		return new ProcessObject();
	}
	
	public IProcessClassification classify(Vector<Vector<String>> testSet,
										   AverageB averageB,
										   AverageM averageM, 
										   StandardDeviationB stdevB, 
										   StandardDeviationM stdevM)
	{
		return new ProcessClassification(testSet, averageB, averageM, stdevB, stdevM);
	}

	
	@Override
	public IProcessInput processInput()
	{
		return new ProcessInput();
	}
	
	

	@Override
	public FileGenerator TestSetFileInstance()
	{
		return new TestFile();
	}

	@Override
	public FileGenerator TrainingSetFileInstance()
	{
		return new TrainingFile();
	}


	@Override
	public ISupportClassifier selectClassifier() 
	{
  		return new SupportClassifier();
	}

	@Override
	public IEnsembleLearningUtil launchUtil()
	{
		return new LaunchUtil();
	}
	@Override
	public double getAccuracyInstance(Vector<Vector<String>> actual, Vector<Vector<String>> predicted)
	{
		return new ComputeAccuracy().getInstance().process(actual, predicted);
	}

}
