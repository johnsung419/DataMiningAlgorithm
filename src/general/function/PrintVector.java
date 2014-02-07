package general.function;

import java.util.Vector;

public class PrintVector {
	public static PrintVector instance;
	private PrintVector() {}
	
	public static PrintVector getInstance()
	{
		if(instance == null)
			instance = new PrintVector();
		
		return instance;
	}
	
	public String performPrint( Vector<Vector<String>> input)
	{
		String buf = "";
		for( int i = 0; i < input.size(); i++)
		{
			Vector<String> column = input.get(i);
			for(int j = 0; j < column.size(); j++)
			{
				buf +=  column.get(j);
				if(j != column.size() - 1)
				{
					buf +=("\t");
				}
			}
			buf += "\n";
		}
	
		return buf;
	}

}
