import java.util.*;
import java.io.*;
public class SingleThreadedMath {
	
	public static void runTheMaths(String inputFile, String outputFile)
	{
			Scanner input = null;
			PrintWriter output = null;
			//Open inputFile for reading
			File f = new File(inputFile);
			
			//Try opening the file for reading.
			try {
				input = new Scanner(f);
			} catch (FileNotFoundException e) {
				System.out.println(inputFile + " was not found in runTheMaths() in SingleThreadedMaths.java");

			}
			
			//Try opening the file for writing
			try {
				output = new PrintWriter(outputFile);
			} catch (FileNotFoundException e) {
				//close the reading file, for tidying up
				input.close();
				System.out.println(inputFile + " was not found in runTheMaths() in SingleThreadedMaths.java");
			}
			
			//one by one, read a line, break it down, and do the maths.
			double operand1, operand2, result;
			String temp;
			char operation;
			while(input.hasNext())
			{
				//read a double
				operand1 = input.nextDouble();
				
				//read the operation as a string
				temp = input.next();
				
				//narrow it down to the single character representation (+,-,*,/)
				operation = temp.charAt(0);
				
				//read a double
				operand2 = input.nextDouble();
				
				
				//Do the math by identifying the operation
				switch(operation) {
					case '+': //lets do some addition
						result = operand1 + operand2;
					break;
					case '-': //lets do some subtraction
						result = operand1 - operand2;
					break;
					case '*': //lets do some multiplication
						result = operand1 * operand2;
					break;
					case '/': //lets do some division
						result = operand1 / operand2;
					break;
					default:
						result = Double.NaN; //Not a number
						System.out.println("Yea, I duno what kind of mathmatical operation this is: " + operation);
						
					
				} //end of switch
				
				//save the result
				output.println(result);
				
			}//end of while loop
			
			//close/save the files
			input.close();
			output.close();
	}//end of method runTheMaths

}
