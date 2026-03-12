/*
 * This code was created by Clinton Rogers for the specific intent of being used by his students.
 * Derivative works based on this code may only be submitted to myCourses, and a copy local to the students
 * own computer. At no time should this code, derivative or otherwise, be shared with other students,
 * people, or posted online.
 */

import java.util.Random;
import java.util.Scanner;


public class TrackCarver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.println("How high would you like the track to be? (Even numbers will be converted to odd)");
		int y = kb.nextInt();
		
		System.out.println("How width would you like the track to be? (Even numbers will be converted to odd)");
		int x = kb.nextInt();
		
		//Make sure the sizes are not negative
		y = Math.abs(y);
		x = Math.abs(x);
		
		//and make sure they are odd values
		if(y%2 == 0)
			y++;
		
		if(x%2 == 0)
			x++;
		
		//Create the grid
		char [][] grid = new char[x][y];
		TrackGenerator.generateMaze(grid,1,1);

		//Print the grid to a textfile or "" to print to screen
		TrackGenerator.printMatrix(grid,"track");
		
		System.out.println("Done!");
		
	}

}
