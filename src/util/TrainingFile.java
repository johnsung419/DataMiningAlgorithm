package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class TrainingFile extends FileGenerator
{

	@Override
	public void excute(String fileName, Vector<Vector<String>> testSet) throws IOException
	{
	 	FileWriter fstream = new FileWriter(fileName);
    	BufferedWriter out = new BufferedWriter(fstream);

    	String fileContents = "";
    	fileContents += "@relation training-set\n";
    	fileContents += "\n";

    	fileContents += "@attribute valueone numeric\n";
    	fileContents += "@attribute valuetwo real\n";
    	fileContents += "@attribute valuethree real\n";
    	fileContents += "@attribute valuefour real\n";
    	fileContents += "@attribute valuefive real\n";
    	fileContents += "@attribute valuesix real\n";
    	fileContents += "@attribute valueseven real\n";
    	fileContents += "@attribute valueeight real\n";
    	fileContents += "@attribute valuenine real\n";
    	fileContents += "@attribute valueten real\n";
    	fileContents += "@attribute valueeleven real\n";
    	fileContents += "@attribute valuetwelve real\n";
    	fileContents += "@attribute valuethirteen real\n";
    	fileContents += "@attribute valuefourteen real\n";
    	fileContents += "@attribute valuefifteen real\n";
    	fileContents += "@attribute valuesixteen real\n";
    	fileContents += "@attribute valueseventeen real\n";
    	fileContents += "@attribute valueeightteen real\n";
    	fileContents += "@attribute valuenineteen real\n";
    	fileContents += "@attribute valuetwenty real\n";
    	fileContents += "@attribute valuetwentyone real\n";
    	fileContents += "@attribute valuetwentytwo real\n";
    	fileContents += "@attribute valuetwentythree real\n";
    	fileContents += "@attribute valuetwentyfour real\n";
    	fileContents += "@attribute valuetwentyfive real\n";
    	fileContents += "@attribute valuetwentysix real\n";
    	fileContents += "@attribute valuetwentyseven real\n";
    	fileContents += "@attribute valuetwentyeight real\n";
    	fileContents += "@attribute valuetwentynine real\n";
    	fileContents += "@attribute valuethirty real\n";
    	fileContents += "@attribute class {B,M}\n";
    	fileContents += "\n";
    	fileContents += "@data\n";
    	fileContents += "\n";
		String vectorRead = super.printVectors(testSet);
		fileContents += vectorRead;		
		out.write(fileContents);		
        out.close();
		
	}

}
