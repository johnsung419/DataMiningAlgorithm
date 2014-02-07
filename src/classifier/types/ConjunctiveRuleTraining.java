package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class ConjunctiveRuleTraining implements IChooseClassifier
{
	public static ConjunctiveRuleTraining instance;
	private ConjunctiveRuleTraining() {}
	
	public static ConjunctiveRuleTraining getInstance()
	{
		if(instance == null)
			instance = new ConjunctiveRuleTraining();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.ConjunctiveRuleTraining;
	}

}
