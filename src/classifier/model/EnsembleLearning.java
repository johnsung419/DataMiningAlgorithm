package classifier.model;

import general.function.DisplayOperation;
import general.function.PrintUtil;

import java.io.IOException;
import java.util.Vector;

import classifier.functions.ClassifierFactory;

public class EnsembleLearning
{
	private Vector<Vector<String>> _A;
	private Vector<Vector<String>> _B;
	private Vector<Vector<String>> _C;
	private Vector<Vector<String>> _D;
	private Vector<Vector<String>> _E;

	private String _resultFileName;
    private Vector<Vector<String>> _testSet;
    private Vector<Vector<String>> _ensembleResult;
    
	public EnsembleLearning(String resultFileName,
							Vector<Vector<String>> testSet,
							Vector<Vector<String>> A,
							Vector<Vector<String>> B,
							Vector<Vector<String>> C,
							Vector<Vector<String>> D,
							Vector<Vector<String>> E) throws IOException
	{
		_resultFileName = resultFileName;
		_testSet = testSet;
		_ensembleResult = new Vector<Vector<String>>();
		_A = A;
		_B = B;
		_C = C;
		_D = D;
		_E = E;
		
		run();
	}
	
	//If class label is B, put 1
	//else               , put 0 on the matrix
	public void run() throws IOException
	{		
		Vector<String> resultA = ClassifierFactory.getInstance().launchUtil().getVoteResult(_A);
		Vector<String> resultB = ClassifierFactory.getInstance().launchUtil().getVoteResult(_B);
		Vector<String> resultC = ClassifierFactory.getInstance().launchUtil().getVoteResult(_C);
		Vector<String> resultD = ClassifierFactory.getInstance().launchUtil().getVoteResult(_D);
		Vector<String> resultE = ClassifierFactory.getInstance().launchUtil().getVoteResult(_E);
		
		Vector<Vector<String>> voteMatrix = ClassifierFactory.getInstance()
															 .launchUtil()
															 .integrateResult( resultA, resultB, resultC, resultD, resultE);
		
		Vector<Vector<String>> voteResult = ClassifierFactory.getInstance()
															 .launchUtil()
															 .countVotes( voteMatrix );
		
		
		ClassifierFactory.getInstance().launchUtil().classify( _resultFileName, _testSet, voteResult );
		
		PrintUtil.getInstance().printBlankLine();
		PrintUtil.getInstance().printLine("Ensemble Learning Result: ");
		PrintUtil.getInstance().printBlankLine();
		PrintUtil.getInstance().printBlankLine();
		
		DisplayOperation.getInstance().MatrixOnConsole(_testSet);
	}
	
	public Vector<Vector<String>> getClassifiedModel()
	{
		return _testSet;
	}
	

}
