package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class DecisionTreeTraining implements IChooseClassifier
{
	public static DecisionTreeTraining instance;
	private DecisionTreeTraining() {}
	
	public static DecisionTreeTraining getInstance()
	{
		if(instance == null)
			instance = new DecisionTreeTraining();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.DecisionTreeTraining;
	}

}
