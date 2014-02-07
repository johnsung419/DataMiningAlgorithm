package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class LogisticRegressionEval implements IChooseClassifier
{
	public static LogisticRegressionEval instance;
	private LogisticRegressionEval() {}
	
	public static LogisticRegressionEval getInstance()
	{
		if(instance == null)
			instance = new LogisticRegressionEval();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.LogisticRegressionEval;
	}
	

}
