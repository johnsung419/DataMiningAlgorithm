package classifier.functions;

import java.io.IOException;
import java.util.Vector;

public interface IProcessInput extends IClassifier 
{
	public String readFileAsString(String filePath) throws IOException;
	public Vector<Vector<String>> getMatrix(String fileRead);
	public Vector<Vector<String>> removeClassLabels(Vector<Vector<String>> trainingSet);
}
