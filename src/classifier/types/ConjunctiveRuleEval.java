package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class ConjunctiveRuleEval implements IChooseClassifier
{
	public static ConjunctiveRuleEval instance;
	private ConjunctiveRuleEval() {}
	
	public static ConjunctiveRuleEval getInstance()
	{
		if(instance == null)
			instance = new ConjunctiveRuleEval();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.ConjunctiveRuleEval;
	}

}
