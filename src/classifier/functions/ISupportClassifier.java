package classifier.functions;

import java.io.IOException;
import java.util.Vector;

public interface ISupportClassifier extends IClassifier
{

	Vector<Vector<String>> process(IChooseClassifier classifier) throws IOException;

}
