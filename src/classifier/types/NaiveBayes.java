package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class NaiveBayes implements IChooseClassifier
{
	public static NaiveBayes instance;
	private NaiveBayes() {}
	
	public static NaiveBayes getInstance()
	{
		if(instance == null)
			instance = new NaiveBayes();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.NaiveBayes;
	}
	

}
