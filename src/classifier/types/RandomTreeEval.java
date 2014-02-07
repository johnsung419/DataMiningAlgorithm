package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class RandomTreeEval implements IChooseClassifier
{
	public static RandomTreeEval instance;
	private RandomTreeEval() {}
	
	public static RandomTreeEval getInstance()
	{
		if(instance == null)
			instance = new RandomTreeEval();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.RandomTreeEval;
	}
	

}
