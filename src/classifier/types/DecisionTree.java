package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class DecisionTree implements IChooseClassifier
{
	public static DecisionTree instance;
	private DecisionTree() {}
	
	public static DecisionTree getInstance()
	{
		if(instance == null)
			instance = new DecisionTree();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.DecisionTree;
	}
	

}
