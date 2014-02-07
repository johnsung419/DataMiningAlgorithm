package classifier.functions;

import java.util.Vector;

public interface IProcessObject extends IClassifier
{
	public Vector<Vector<String>> trimObject(Vector<Vector<String>> input);
	public Vector<Vector<String>> addObjectIds(Vector<Vector<String>> testSets, Vector<Vector<String>> classified);
	public Vector<Vector<String>> reformatObjects(Vector<Vector<String>> input);
    public Vector<Vector<String>> reformatObjectForTestset(Vector<Vector<String>> input);

	
}
