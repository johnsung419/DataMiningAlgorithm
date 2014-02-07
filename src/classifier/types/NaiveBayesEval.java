package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class NaiveBayesEval implements IChooseClassifier
{
	public static NaiveBayesEval instance;
	private NaiveBayesEval() {}
	
	public static NaiveBayesEval getInstance()
	{
		if(instance == null)
			instance = new NaiveBayesEval();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.NaiveBayesEval;
	}

}
