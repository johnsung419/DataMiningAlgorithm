package classifier.util;

import general.function.CopyVector;

import java.util.Vector;

import classifier.functions.IProcessObject;

public class ProcessObject implements IProcessObject 
{
    public ProcessObject() { }

    
	@Override
	public Vector<Vector<String>> trimObject(Vector<Vector<String>> input ) {

		Vector<Vector<String>> trimmed = CopyVector.getInstance().performCopy( input );
		
		for(int i = 0; i < trimmed.size(); i++)
		{
			trimmed.elementAt(i).remove(0);
		}
			
		return trimmed;
	}
	
	public Vector<Vector<String>> addObjectIds(Vector<Vector<String>> testSets, Vector<Vector<String>> classified)
	{
		Vector<Vector<String>> output = new Vector<Vector<String>>( classified );
		for(int i = 0; i < testSets.size(); i++)
		{
			output.get(i).add( 0 , testSets.get(i).get(0) );
		}
		
		return output;
	}
	
	
	public Vector<Vector<String>> reformatObjects(Vector<Vector<String>> input)
	{
		Vector<Vector<String>> tempInput = new Vector<Vector<String>>(  );
		Vector<String> column = new Vector<String>();
		for(int i = 0; i < input.size(); i++)
		{
			Vector<String> element = input.get(i);
			for(int j = 2; j < element.size(); j++)
			{
				column.add( element.get(j));
			}
			tempInput.add(column);
			column = new Vector<String>();
		}

		//Add the class label in the back.

		for(int r = 0; r < tempInput.size(); r++)
		{
			Vector<String> element = tempInput.get(r);
			element.add(input.get(r).get(1));
		}

		return tempInput;
	}

	//Reformat the object in a way that puts class in the last column 
	public Vector<Vector<String>> reformatObjectForTestset(Vector<Vector<String>> input)
	{
		Vector<Vector<String>> tempInput = new Vector<Vector<String>>(  );
		Vector<String> column = new Vector<String>();
		for(int i = 0; i < input.size(); i++)
		{
			Vector<String> element = input.get(i);
			for(int j = 1; j < element.size(); j++)
			{
				column.add( element.get(j));
			}
			column.add("?");
			tempInput.add(column);
			column = new Vector<String>();
		}


		return tempInput;
	}

	
	
}
