package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class NaiveBayesTraining implements IChooseClassifier
{
	public static NaiveBayesTraining instance;
	private NaiveBayesTraining() {}
	
	public static NaiveBayesTraining getInstance()
	{
		if(instance == null)
			instance = new NaiveBayesTraining();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.NaiveBayesTraining;
	}

}
