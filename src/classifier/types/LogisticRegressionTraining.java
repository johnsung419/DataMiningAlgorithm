package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class LogisticRegressionTraining implements IChooseClassifier
{
	public static LogisticRegressionTraining instance;
	private LogisticRegressionTraining() {}
	
	public static LogisticRegressionTraining getInstance()
	{
		if(instance == null)
			instance = new LogisticRegressionTraining();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.LogisticRegressionTraining;
	}

}
