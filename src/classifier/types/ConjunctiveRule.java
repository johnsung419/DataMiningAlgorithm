package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class ConjunctiveRule implements IChooseClassifier
{
	public static ConjunctiveRule instance;
	private ConjunctiveRule() {}
	
	public static ConjunctiveRule getInstance()
	{
		if(instance == null)
			instance = new ConjunctiveRule();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.ConjunctiveRule;
	}

}
