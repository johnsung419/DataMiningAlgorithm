package classifier.util;

import general.function.CopyVector;

import java.io.IOException;
import java.util.Vector;

import classifier.functions.ClassifierFactory;
import classifier.functions.IEnsembleLearningUtil;

public class LaunchUtil implements IEnsembleLearningUtil
{

	@Override
	public Vector<String> getVoteResult(Vector<Vector<String>> input)
	{
		Vector<String> result = new Vector<String>();
		for(int i = 0; i < input.size(); i++)
		{
			if(input.get(i).get(1).equalsIgnoreCase("B"))
			{
				result.add("1");
			}
			else
			{
				result.add("0");
			}
		}
		
		return result;
	}

	@Override
	public Vector<Vector<String>> integrateResult(Vector<String> resultA,
											      Vector<String> resultB, 
											      Vector<String> resultC,
											      Vector<String> resultD, 
											      Vector<String> resultE)
	{
		Vector<Vector<String>> voteCombined = new Vector<Vector<String>>();
		Vector<String> element = new Vector<String>();
		for(int i = 0; i < resultA.size(); i++)
		{
			element.add( resultA.get(i));
			element.add( resultB.get(i));
			element.add( resultB.get(i));
			element.add( resultB.get(i));
			element.add( resultB.get(i));
			voteCombined.add(element);
			element = new Vector<String>();
		}

		return voteCombined;
	}

	@Override
	public Vector<Vector<String>> countVotes(Vector<Vector<String>> combined) 
	{
		Vector<Vector<String>> voteCount = new Vector<Vector<String>>();
		Vector<String> column = new Vector<String>();
		for(int i = 0; i < combined.size(); i++)
		{
			int countClassB = 0;
			int countClassM = 0;
			Vector<String> element = combined.get(i);
			for(int j = 0; j < element.size(); j++)
			{
				if(element.elementAt(j).equalsIgnoreCase("1"))
				{
					countClassB++;
				}
				else
				{
					countClassM++;
				}
			}
			column.add(String.valueOf(countClassB));
			column.add(String.valueOf(countClassM));
			voteCount.add(column);
			column = new Vector<String>();
		}
		
		return voteCount;
	}

	@Override
	public void classify(String resultFileName, Vector<Vector<String>> testSet, Vector<Vector<String>> voteResult) throws IOException 
	{
		Vector<String> classLabel = new Vector<String>();
		for(int j = 0; j < voteResult.size(); j++)
		{
			if(Integer.parseInt( voteResult.get(j).get(0) ) > Integer.parseInt( voteResult.get(j).get(1) ) )
			{
				classLabel.add("B");
			}
			else
			{
				classLabel.add("M");
			}

		}
		
		//print the result class label on the file
		ClassifierFactory.getInstance().TestSetFileInstance().resultFile(resultFileName, classLabel);
		
		Vector<Vector<String>> copiedTestSet = CopyVector.getInstance().performCopy(testSet);
		
		
		for(int i = 0; i < copiedTestSet.size(); i++)
		{
			Vector<String> column = copiedTestSet.get(i);
			column.add(1, classLabel.get(i));
		}

	}

}
