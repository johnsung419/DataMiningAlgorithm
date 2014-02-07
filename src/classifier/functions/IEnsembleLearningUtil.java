package classifier.functions;

import java.io.IOException;
import java.util.Vector;

public interface IEnsembleLearningUtil extends IClassifier{
	
	public Vector<String> getVoteResult(Vector<Vector<String>> input);
	public Vector<Vector<String>> integrateResult(Vector<String> resultA, 
												  Vector<String> resultB, 
												  Vector<String> resultC,
												  Vector<String> resultD,
												  Vector<String> resultE);
	public Vector<Vector<String>> countVotes(Vector<Vector<String>> combined);
	public void classify(String resultFileName, Vector<Vector<String>> testSet, Vector<Vector<String>> voteResult) throws IOException;
}
