package classifier.types;

import classifier.functions.IChooseClassifier;
import classifier.functions.IClassifier.ClassifierType;

public class RandomTree implements IChooseClassifier
{
	public static RandomTree instance;
	private RandomTree() {}
	
	public static RandomTree getInstance()
	{
		if(instance == null)
			instance = new RandomTree();
		
		return instance;
	}
	

	@Override
	public ClassifierType getClassifierType() {
	
		return ClassifierType.RandomTree;
	}
	

}
