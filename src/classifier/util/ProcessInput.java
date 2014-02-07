package classifier.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import classifier.functions.IProcessInput;

public class ProcessInput implements IProcessInput
{

	private static int MAX_BUFFER_SIZE = 10000000;
    // Create a 2D matrix of all of the inputs
 	public Vector<Vector<String>> getMatrix(String fileRead)
 	{

 		String [] split = fileRead.split("\t");// ---> this line is for yeast-undirected_metabolic.txt
 		Vector<String> v = new Vector<String>();	
 		for(int i = 0; i < split.length; i++)
 		{
 			v.add(i, split[i]);
 		}
 		
 		Vector<Vector<String>> mainMatrix = new Vector<Vector<String>>();
 		Vector<String> element = new Vector<String>();
 		for(int i = 0; i < v.size(); i++)
 		{
 			if(v.get(i).contains("\n"))
 			{
 				String [] broken = v.get(i).split("\n");
 				if(broken[0].contains("\r"))
 				{
 					StringTokenizer st = new StringTokenizer(broken[0], "\r");
 					broken[0] = st.nextToken();
 				}

 				element.add(broken[0]);				
 				mainMatrix.add(element);
 				element = new Vector<String>();
 				if(broken.length == 2)
 				{
 					element.add(broken[1]);
 				}
 				
 			}
 			else//v.get(i).contains("\r\n")
 			{
 				element.add(v.get(i));
 			}
 		}
	
 		return mainMatrix;		
 	}
 

	//O(1)
	public String readFileAsString(String filePath) throws IOException
	{
		StringBuffer fileData = new StringBuffer(MAX_BUFFER_SIZE);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char [] buf = new char[MAX_BUFFER_SIZE];
		int numRead = 0;
		while((numRead = reader.read(buf)) != -1)
		{
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[MAX_BUFFER_SIZE];
		}
		reader.close();
		return fileData.toString();
	}


	@Override
	 public Vector<Vector<String>> removeClassLabels(Vector<Vector<String>> trainingSet)
	 {
	    	Vector<Vector<String>> input = new Vector<Vector<String>>(trainingSet);
	    	for(int i = 0; i < input.size(); i++)
	    	{
	    		input.get(i).remove(1);
	    	}
	    	
	    	return input;
	 }
	

}
