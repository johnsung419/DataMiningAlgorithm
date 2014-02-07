package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class LogisticRegression implements IChooseClassifier
{
	public static LogisticRegression instance;
	private LogisticRegression() {}
	
	public static LogisticRegression getInstance()
	{
		if(instance == null)
			instance = new LogisticRegression();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.LogisticRegression;
	}
	

}
