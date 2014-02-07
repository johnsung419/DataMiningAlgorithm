package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class DecisionTreeEval implements IChooseClassifier
{
	public static DecisionTreeEval instance;
	private DecisionTreeEval() {}
	
	public static DecisionTreeEval getInstance()
	{
		if(instance == null)
			instance = new DecisionTreeEval();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType()
	{
	
		return ClassifierType.DecisionTreeEval;
	}
	

}
