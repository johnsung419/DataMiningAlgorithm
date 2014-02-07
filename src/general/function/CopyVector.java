package general.function;

import java.util.Vector;


public class CopyVector 
{
	public static CopyVector instance;
	private CopyVector() {}
	
	public static CopyVector getInstance()
	{
		if(instance == null)
			instance = new CopyVector();
		
		return instance;
	}
	

	public Vector<Vector<String>> performCopy(Vector<Vector<String>> input)
	{
		Vector<Vector<String>> clone = new Vector<Vector<String>>();
		Vector<String> element = new Vector<String>();
		
		for(int i = 0; i < input.size(); i++)
		{
			Vector<String> column = input.get(i);
			for(int j = 0; j < column.size(); j++)
			{
				element.add( column.get(j));
			}
			clone.add(element);
			element = new Vector<String>();
		}
		return clone;
	}
	
	
}
