package classifier.functions;



public interface IClassifier 
{
	public enum ClassifierType
	{
		NaiveBayes,
		ConjunctiveRule,
		DecisionTree,
		LogisticRegression,
		RandomTree,
		NaiveBayesTraining,
		ConjunctiveRuleTraining,
		DecisionTreeTraining,
		LogisticRegressionTraining,
		RandomTreeTraining,
		NaiveBayesEval,
		ConjunctiveRuleEval,
		DecisionTreeEval,
		LogisticRegressionEval,
		RandomTreeEval,
	};

}




