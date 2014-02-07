package general.function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class DisplayOperation
{
	public static DisplayOperation instance;
	private DisplayOperation() {}
	
	public static DisplayOperation getInstance()
	{
		if(instance == null)
			instance = new DisplayOperation();
		
		return instance;
	}
	
	public void MatrixOnConsole(Vector<Vector<String>> input) 
	{
		for(int i = 0; i < input.size(); i++)
		{
			Vector<String> temp = input.get(i);
			for(int j = 0; j < temp.size(); j++)
			{
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();	
		}	
	}
	

	public void MatrixOnFile(String fileName, Vector<Vector<String>> input) throws IOException
	{
		FileWriter fstream = new FileWriter(fileName);
	    BufferedWriter out = new BufferedWriter(fstream);
		
		//write to the file
		Vector<Vector<String>> temp = new Vector<Vector<String>>(input);	
		
		out.write(PrintVector.getInstance().performPrint(temp) );	
        out.close();
		
	}

}
