package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class RandomTreeTraining implements IChooseClassifier
{
	public static RandomTreeTraining instance;
	private RandomTreeTraining() {}
	
	public static RandomTreeTraining getInstance()
	{
		if(instance == null)
			instance = new RandomTreeTraining();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.RandomTreeTraining;
	}

}
