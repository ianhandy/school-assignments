import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MultiThreadedMaths extends Thread {
	private String inputFile, outputFile;
	public MultiThreadedMaths(String inputFileName, String outputFileName)
	{
		//call the constructor for Thread, just in case something important needs to be done.
		super();
		
		//lets save the file names for later
		inputFile = inputFileName;
		outputFile = outputFileName;
	}
	
	public void run()
	{
		SingleThreadedMath.runTheMaths(inputFile, outputFile);
	}

}
