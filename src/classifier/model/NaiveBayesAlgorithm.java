package classifier.model;

import general.function.DisplayOperation;
import general.function.PrintUtil;

import java.io.IOException;
import java.util.Vector;

import classification.AverageB;
import classification.AverageM;
import classification.StandardDeviationB;
import classification.StandardDeviationM;
import classifier.functions.ClassifierFactory;
import classifier.util.ProcessClassification;

public class NaiveBayesAlgorithm 
{
	private Vector<Vector<String>> _objects;
	private Vector<Vector<String>> _testSets;

	private AverageB _B;
	private AverageM _M;
	
	private StandardDeviationB _sB;
	private StandardDeviationM _sM;
	private String _fileName;
	

	public NaiveBayesAlgorithm(String fileName, Vector<Vector<String>> objects, Vector<Vector<String>> tests) throws IOException
	{
		_fileName = fileName;
		_objects = new Vector<Vector<String>>( objects );
		_testSets = new Vector<Vector<String>>( tests );
		
		_B = new AverageB();
		_M = new AverageM();
		
		_sB = new StandardDeviationB();
		_sM = new StandardDeviationM();
		
		run();
		
	}
	
	public void run() throws IOException
	{
		
		Vector<Vector<String>> objects = ClassifierFactory.getInstance()
														  .processObject()
														  .trimObject(_objects);
		
		Vector<Vector<String>> testSet = ClassifierFactory.getInstance()
														  .processObject()
														  .trimObject(_testSets);
		
	
		ClassifierFactory.getInstance().computeAverage(objects, _B, _M);
		
		ClassifierFactory.getInstance().computeStandardDeviation( objects , _B, _M,  _sB,  _sM);

		
		ProcessClassification classifier = (ProcessClassification) ClassifierFactory.getInstance()
																				    .classify( testSet, _B , _M , _sB , _sM );
		
		Vector<Vector<String>> classified = classifier.getClassifiedSet();
		
				
		classified = ClassifierFactory.getInstance()
						 			  .processObject()
						 			  .addObjectIds(_testSets, classified);
	
		
		PrintUtil.getInstance().printLine(" Naive Bayes Algorithm Implemented ");
		PrintUtil.getInstance().printBlankLine();
		PrintUtil.getInstance().printBlankLine();
		
		DisplayOperation.getInstance()
						.MatrixOnConsole(classified);
		
	 	DisplayOperation.getInstance().MatrixOnFile(_fileName, classified);	
	
	}

}
