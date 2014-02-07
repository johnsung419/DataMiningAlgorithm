
/**  CSE601 Project 3
 *   Implementation of Naive Bayes Classification Algorithm and Ensemble Learning Approach through Majority Voting
 * 
 * Author : Hyunwoo Sung
 * 
 */

package driver;

import general.function.PrintUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import algorithm.functions.AlgorithmFactory;

import classifier.functions.ClassifierFactory;
import classifier.model.EnsembleLearning;
import classifier.types.ConjunctiveRule;
import classifier.types.ConjunctiveRuleEval;
import classifier.types.ConjunctiveRuleTraining;
import classifier.types.DecisionTree;
import classifier.types.DecisionTreeEval;
import classifier.types.DecisionTreeTraining;
import classifier.types.LogisticRegression;
import classifier.types.LogisticRegressionEval;
import classifier.types.LogisticRegressionTraining;
import classifier.types.NaiveBayes;
import classifier.types.NaiveBayesEval;
import classifier.types.NaiveBayesTraining;
import classifier.types.RandomTree;
import classifier.types.RandomTreeEval;
import classifier.types.RandomTreeTraining;


public class Launch 
{
    public static void main(String [] args) throws IOException
	{		
    	//1. Predict the class label by learning training set and using testset 
    	
		String trainingSetRead  = ClassifierFactory.getInstance()
							                       .processInput()
							                       .readFileAsString( "training.txt" );
		
		String testSetRead = ClassifierFactory.getInstance()
												   .processInput()
												   .readFileAsString( "test.txt" );
		
	    Vector<Vector<String>> trainingSets = ClassifierFactory.getInstance()
                												.processInput()
                												.getMatrix(trainingSetRead);
		
	    Vector<Vector<String>> testSets = ClassifierFactory.getInstance()
														   .processInput()
														   .getMatrix(testSetRead);

	    Vector<Vector<String>> trimmedTrainingSets = ClassifierFactory.getInstance()
	 			  									                  .processObject()
	 			  									                  .reformatObjects( trainingSets);
	    
	    Vector<Vector<String>> trimmedTestSets = ClassifierFactory.getInstance()
	                  											  .processObject()
	                  											  .reformatObjectForTestset( testSets );
	
	    
        ClassifierFactory.getInstance()
        				 .TestSetFileInstance()
        				 .excute( "training.arff", trimmedTrainingSets);
        
        ClassifierFactory.getInstance()
        				 .TrainingSetFileInstance()
        				 .excute( "test.arff", trimmedTestSets);
   
        
        AlgorithmFactory.getInstance().getNaive()
        							  .createAlgorithm("naive_bayes_with_testset.txt", trainingSets, testSets);

       
        
	    Vector<Vector<String>> conjunctive = ClassifierFactory.getInstance().selectClassifier().process(ConjunctiveRule.getInstance());
	    
	    Vector<Vector<String>> decision = ClassifierFactory.getInstance().selectClassifier().process(DecisionTree.getInstance());

	    Vector<Vector<String>> logistic = ClassifierFactory.getInstance().selectClassifier().process(LogisticRegression.getInstance());

	    Vector<Vector<String>> naive =  ClassifierFactory.getInstance().selectClassifier().process(NaiveBayes.getInstance());

	    Vector<Vector<String>> random = ClassifierFactory.getInstance().selectClassifier().process(RandomTree.getInstance());

	    Vector<Vector<String>> testSetForEnsemble = ClassifierFactory.getInstance()
	    															 .processInput()
	    															 .getMatrix(testSetRead);
	    
	    
	    AlgorithmFactory.getInstance()
					    .getEnsemble()
					    .createAlgorithm(
					    		"ensemble_prediction_result_file.txt",
					    		testSetForEnsemble, 
					    		conjunctive, 
					    		decision, 
					    		logistic, 
					    		naive, 
					    		random);

	    
	    
	    //2. Evaluate the performance by using the training data as a test set
	    //read the training set again
		String trainingSetRead2  = ClassifierFactory.getInstance()
									                .processInput()
									                .readFileAsString( "training.txt" );
		//generate the vector and store the contents in the vector
		 Vector<Vector<String>> trainingSets2 = ClassifierFactory.getInstance()
																 .processInput()
																 .getMatrix(trainingSetRead2);	
		
	    //remove the class labels to make it look like a test set
	    trainingSets2 = ClassifierFactory.getInstance().processInput()
	    											   .removeClassLabels(trainingSets2);
	    
	    //generate .arff file with training set
	    Vector<Vector<String>> trimmedTestSets2 = ClassifierFactory.getInstance()
				  												   .processObject()
				  												   .reformatObjectForTestset( trainingSets2 );
	    ClassifierFactory.getInstance()
		 				 .TestSetFileInstance()
		 				 .excute( "testset_by_training_set.arff", trimmedTestSets2);
	    
	    
	    // run the naive bayes again with the newly generated test set
        AlgorithmFactory.getInstance()
	    				.getNaive()
	    				.createAlgorithm("naive_bayes_with_trainingset.txt", 
	    				                  trainingSets, 
	    							  	  trainingSets2);
	    
	    Vector<Vector<String>> conjunctive_training = ClassifierFactory.getInstance().selectClassifier().process(ConjunctiveRuleTraining.getInstance());
	    
	    Vector<Vector<String>> decision_training = ClassifierFactory.getInstance().selectClassifier().process(DecisionTreeTraining.getInstance());

	    Vector<Vector<String>> logistic_training = ClassifierFactory.getInstance().selectClassifier().process(LogisticRegressionTraining.getInstance());

	    Vector<Vector<String>> naive_training =  ClassifierFactory.getInstance().selectClassifier().process(NaiveBayesTraining.getInstance());

	    Vector<Vector<String>> random_training = ClassifierFactory.getInstance().selectClassifier().process(RandomTreeTraining.getInstance());
	    
	    
	    Vector<Vector<String>> testSet_with_trainingset_ForEnsemble = ClassifierFactory.getInstance()
				 																	   .processInput()
				 																	   .getMatrix(trainingSetRead);
	    
	    EnsembleLearning ensemble_training = AlgorithmFactory.getInstance()
															 .getEnsemble()
															 .createAlgorithm(
																"result_file_with_trainingset.txt",
															    testSet_with_trainingset_ForEnsemble, 
															    conjunctive_training, 
															    decision_training, 
															    logistic_training, 
															    naive_training, 
															    random_training);
	    
	    //evaluate the performance
	    PrintUtil.getInstance().printLine("Press Enter to continue ...");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String userName = br.readLine();

	    if(userName == "\n")
	    {
		    PrintUtil.getInstance().printBlankLine();
		    PrintUtil.getInstance().printBlankLine();	    
		    PrintUtil.getInstance().printLine("======================================================================");
		    PrintUtil.getInstance().printLine("I. Requirement Part");
		    PrintUtil.getInstance().printLine("Performance Evaluation with test set created by training set");
		    PrintUtil.getInstance().printBlankLine();
		    
		    AlgorithmFactory.getInstance()
						    .getEvaluator( "NaiveBayes_Model", trainingSets, naive_training );
		    PrintUtil.getInstance().printBlankLine();	    
		   
		    AlgorithmFactory.getInstance()
		    				.getEvaluator( "ConjunctiveRule_Model", trainingSets, conjunctive_training);
		    PrintUtil.getInstance().printBlankLine();
		    
		    AlgorithmFactory.getInstance()
		    				.getEvaluator( "Decision_Model", trainingSets, decision_training);
		    
		    PrintUtil.getInstance().printBlankLine();
		    
		    AlgorithmFactory.getInstance()
		    				.getEvaluator( "LogisticRegression_Model", trainingSets, logistic_training);
		    
		    PrintUtil.getInstance().printBlankLine();
		    
		    AlgorithmFactory.getInstance()
		    				.getEvaluator( "RandomTree_Model", trainingSets, random_training);
		    PrintUtil.getInstance().printBlankLine();
		    
		    AlgorithmFactory.getInstance()
		    				.getEvaluator( "Ensemble_Model", trainingSets, ensemble_training.getClassifiedModel());
		    PrintUtil.getInstance().printBlankLine();
		    
	    }
	    
	    
	    //COMPETITION PART
	    /**
	     * 1. generate an evaluation set by using test set
	     * 2. run all of the algorithms in order to get the classification result
	     * 3. get the performance result 
	     *    Actual would be the test set class label classified by all models
	     *    Predictted would be the one from running the algorithm from evaluation set
	     * 
	     */
//		String testSetRead3 = ClassifierFactory.getInstance()
//											   .processInput()
//											   .readFileAsString( "test.txt" );
//		
//		Vector<Vector<String>> testSets3 = ClassifierFactory.getInstance()
//				   											   .processInput()
//				   											   .getMatrix(testSetRead3);
//		
//		Vector<Vector<String>> trimmedTestSets3 = ClassifierFactory.getInstance()
//				   												   .processObject()
//				   												   .trimObject( testSets3 );
//	    
//	    ClassifierFactory.getInstance().TestSetFileInstance()
//	    							   .evaluationSetFile("evaluation_set.txt", trimmedTestSets3);
	    
		String trainingSetRead3  = ClassifierFactory.getInstance()
                								    .processInput()
                								    .readFileAsString( "training_set_from_ensemble.txt" );
	    
		String evaluationSetRead = ClassifierFactory.getInstance()
				   								    .processInput()
				   								    .readFileAsString( "evaluation_set.txt" );
		
	    Vector<Vector<String>> trainingSet3 = ClassifierFactory.getInstance()
	    													   .processInput()
	    													   .getMatrix(trainingSetRead3);
		
	    Vector<Vector<String>> evaluationSet = ClassifierFactory.getInstance()
				   										        .processInput()
				   										        .getMatrix(evaluationSetRead);
	    
	    Vector<Vector<String>> trimmedTrainingSets3 = ClassifierFactory.getInstance()
	                  					         			   		   .processObject()
	                  					         			   		   .reformatObjects( trainingSet3);
		
		 Vector<Vector<String>> trimmedTestSets3 = ClassifierFactory.getInstance()
				 												   .processObject()
				 												   .reformatObjectForTestset( evaluationSet );
		 
	      ClassifierFactory.getInstance()
			 			   .TrainingSetFileInstance()
			 			   .excute( "evaluation.arff", trimmedTestSets3);

	      ClassifierFactory.getInstance()
			 			   .TestSetFileInstance()
			 			   .excute( "training_from_ensemble.arff", trimmedTrainingSets3);

	      AlgorithmFactory.getInstance()
	      				  .getNaive()
						  .createAlgorithm("naive_bayes_with_evaluation_set.txt", trainingSet3, evaluationSet);
	      
	      
	      Vector<Vector<String>> conjunctive_evaluation = ClassifierFactory.getInstance().selectClassifier().process(ConjunctiveRuleEval.getInstance());
		    
		  Vector<Vector<String>> decision_evaluation = ClassifierFactory.getInstance().selectClassifier().process(DecisionTreeEval.getInstance());

		  Vector<Vector<String>> logistic_evaluation = ClassifierFactory.getInstance().selectClassifier().process(LogisticRegressionEval.getInstance());

		  Vector<Vector<String>> naive_evaluation =  ClassifierFactory.getInstance().selectClassifier().process(NaiveBayesEval.getInstance());

		  Vector<Vector<String>> random_evaluation = ClassifierFactory.getInstance().selectClassifier().process(RandomTreeEval.getInstance());
		    
		   Vector<Vector<String>> testSet_with_evaluation_set_ForEnsemble = ClassifierFactory.getInstance()
																							   .processInput()
																							   .getMatrix(evaluationSetRead);

		   AlgorithmFactory.getInstance()
						   .getEnsemble()
						   .createAlgorithm(
								   "result_file_with_evaluation_set.txt",
								   testSet_with_evaluation_set_ForEnsemble, 
								   conjunctive_evaluation, 
								   decision_evaluation, 
								   logistic_evaluation, 
								   naive_evaluation, 
								   random_evaluation);
		   
		   
		    
		    //evaluate the performance
		    PrintUtil.getInstance().printLine("Press Enter to continue ...");
		    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		    String userName2 = br2.readLine();
		    

		    PrintUtil.getInstance().printBlankLine();
		    PrintUtil.getInstance().printBlankLine();	    
		    PrintUtil.getInstance().printLine("======================================================================");
		    PrintUtil.getInstance().printLine("II. Competition Part");
		    PrintUtil.getInstance().printLine("Performance Evaluation with evaluation set created by training set");
		    PrintUtil.getInstance().printBlankLine();

		    AlgorithmFactory.getInstance()
		    .getEvaluator( "NaiveBayes_Model", trainingSet3, naive_evaluation );
		    PrintUtil.getInstance().printBlankLine();	    

		    AlgorithmFactory.getInstance()
		    .getEvaluator( "ConjunctiveRule_Model", trainingSet3, conjunctive_evaluation);
		    PrintUtil.getInstance().printBlankLine();

		    AlgorithmFactory.getInstance()
		    .getEvaluator( "Decision_Model", trainingSet3, decision_evaluation);

		    PrintUtil.getInstance().printBlankLine();

		    AlgorithmFactory.getInstance()
		    .getEvaluator( "LogisticRegression_Model", trainingSet3, logistic_evaluation);

		    PrintUtil.getInstance().printBlankLine();

		    AlgorithmFactory.getInstance()
		    .getEvaluator( "RandomTree_Model", trainingSet3, random_evaluation);
		    PrintUtil.getInstance().printBlankLine();

		    //For ensemble
		    String ensemblePredictionRead  = ClassifierFactory.getInstance()
											                    .processInput()
											                    .readFileAsString( "ensemble_result_evaluation_set.txt" );

		    Vector<Vector<String>> ensembleResultSet = ClassifierFactory.getInstance()
																		.processInput()
																		.getMatrix(ensemblePredictionRead);
															    
		    
		    AlgorithmFactory.getInstance()
						    .getEvaluator( "Ensemble_Model", trainingSet3, ensembleResultSet);
			PrintUtil.getInstance().printBlankLine();

		    
	    
	    
	}
}
