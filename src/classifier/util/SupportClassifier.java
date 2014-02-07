package classifier.util;

import java.io.IOException;
import java.util.Vector;

import classifier.functions.ClassifierFactory;
import classifier.functions.IChooseClassifier;
import classifier.functions.ISupportClassifier;

public class SupportClassifier implements ISupportClassifier
{
	
	@Override
	public Vector<Vector<String>> process(IChooseClassifier classifier) throws IOException
	{
		String fileRead = "";

    	switch(classifier.getClassifierType())
  	    {
  	    	case	NaiveBayes:
  	    		fileRead  = ClassifierFactory.getInstance()
  	    												   .processInput()
  	    												   .readFileAsString( "naive_bayes_with_testset.txt" );

  	    	break;
  	    	case	ConjunctiveRule:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "conjunctive_rule_with_testset.txt" );
  	  	    break;

  	    	case	DecisionTree:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "decision_tree_with_testset.txt" );
  	  	    break;

  	    	case	LogisticRegression:
  	    		fileRead  = ClassifierFactory.getInstance()
  	    													.processInput()
  	    													.readFileAsString( "logistic_regression_with_testset.txt" );
  	  	    break;

  	    	case	RandomTree:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "random_tree_with_testset.txt" );
  	        
  	    		//by using the training set
  	    	case	NaiveBayesTraining:
  	    		fileRead  = ClassifierFactory.getInstance()
  	    												   .processInput()
  	    												   .readFileAsString( "naive_bayes_with_trainingset.txt" );

  	    	break;
  	    	case	ConjunctiveRuleTraining:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "conjunctive_rule_with_trainingset.txt" );
  	  	    break;

  	    	case	DecisionTreeTraining:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "decision_tree_with_trainingset.txt" );
  	  	    break;

  	    	case	LogisticRegressionTraining:
  	    		fileRead  = ClassifierFactory.getInstance()
  	    													.processInput()
  	    													.readFileAsString( "logistic_regression_with_trainingset.txt" );
  	  	    break;

  	    	case	RandomTreeTraining:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "random_tree_with_trainingset.txt" );
  	    		//by using an evaluation set
  	    		
	    	case	NaiveBayesEval:
  	    		fileRead  = ClassifierFactory.getInstance()
  	    												   .processInput()
  	    												   .readFileAsString( "naive_bayes_with_evaluation_set.txt" );

  	    	break;
  	    	case	ConjunctiveRuleEval:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "conjunctive_rule_evaluation_set.txt" );
  	  	    break;

  	    	case	DecisionTreeEval:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "decision_tree_evaluation_set.txt" );
  	  	    break;

  	    	case	LogisticRegressionEval:
  	    		fileRead  = ClassifierFactory.getInstance()
  	    													.processInput()
  	    													.readFileAsString( "logistic_regression_evaluation_set.txt" );
  	  	    break;

  	    	case	RandomTreeEval:
  	    		fileRead  = ClassifierFactory.getInstance()
				   											.processInput()
				   											.readFileAsString( "random_tree_evaluation_set.txt" );
  	    		
  	    		
  	  	    break;


  	    }
    	
  		return ClassifierFactory.getInstance().processInput().getMatrix(fileRead);
	}


}
