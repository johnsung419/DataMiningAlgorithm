package util;

import general.function.FormatDecimal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public abstract class FileGenerator
{
	public abstract void excute(String fileName, Vector<Vector<String>> testSet) throws IOException;	

	public void resultFile(String resultFileName, Vector<String> result) throws IOException
	{
		FileWriter fstream = new FileWriter(resultFileName);
    	BufferedWriter out = new BufferedWriter(fstream);
		out.write(printString(result));
		
		out.close();
	}
	
	public void evaluationSetFile(String fileName, Vector<Vector<String>> testSet) throws IOException
	{
		FileWriter fstream = new FileWriter(fileName);
    	BufferedWriter out = new BufferedWriter(fstream);
		out.write(printEvaluationMatrix(testSet));
		
		out.close();
	}
	
	
	public double randomNumberGenerator(double max, double min)
	{
		double r = min + (Math.random() * (max - min) );
		return r;
	}
	
	public String printEvaluationMatrix(Vector<Vector<String>> testSetMatrix)
	{
		double [] maxValues = new double[testSetMatrix.get(0).size()];
		double [] minValues = new double[testSetMatrix.get(0).size()];
	
		
		for(int i = 0; i < testSetMatrix.get(0).size(); i++)
		{
			Vector<Double> holder = new Vector<Double>();
			for(int j = 0; j < testSetMatrix.size(); j++)
			{
				String each = testSetMatrix.get(j).get(i);
				holder.add(Double.parseDouble( each ));
			}
			double max = Collections.max( holder );
			double min = Collections.min( holder );
			
			maxValues[i] = max;
			minValues[i] = min;
		}
		
		String matrix = new String("");
		for(int r = 0; r < testSetMatrix.size(); r++)
		{
			Vector<String> column = testSetMatrix.get(r);
			for(int c = 0; c < column.size(); c++)
			{
				double ran = randomNumberGenerator( maxValues[c] , minValues[c] );
				matrix += FormatDecimal.getInstance().performFormat( ran );
				if( c != column.size() - 1)
				{
					matrix += "\t";
				}
			}
			matrix += "\n";
		}
		
		return matrix;
	}
	
	public String printVectors(Vector<Vector<String>> input)
	{
		String buf = "";
		for( int i = 0; i < input.size(); i++)
		{
			Vector<String> column = input.get(i);
			for(int j = 0; j < column.size(); j++)
			{
				buf += ( column.get(j) );
				if(j != column.size() - 1)
				{
					buf +=(",");
				}
			}
			buf += "\n";
		}

		return buf;
	}
	
	public String printString(Vector<String> input)
	{
		String buf = "";
		for( int i = 0; i < input.size(); i++)
		{
		    buf += ( input.get(i) );
			buf += "\n";
		}

		return buf;
	}
}
