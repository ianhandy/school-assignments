/*
 * Programmer/Student Name: Ian Handy
 * Date: 3/31/26
 * Class Description: Test driver for JBV Wobblations
 * 
 * Other Details:
 * Instructor: Clinton Rogers
 * Class: CIS 181
 * 
 * This Code and all derivatives are explicitly for this class only. Sharing of code openly online is explicitly forbidden.  
 */

import java.io.*;
import java.util.*;
public class TestJBVMethod {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		JasonBVieiraWobblations jbv = new JasonBVieiraWobblations();
		
		//Get the x and y values from the user
		System.out.println("Please give me a positive x value");
		int x = in.nextInt();
		
		System.out.println("Please give me a positive y value");
		int y = in.nextInt();
		
		//Just force positive values in case they gave a negative
		x=Math.abs(x);
		y=Math.abs(y);
		
		
		int wobblationSum = jbv.simulateWobblations(x,y);
		
		System.out.println("The Final Wobblation Sum is "+wobblationSum + " after " + jbv.getInvocations() + " invocation calls");
	}

}
