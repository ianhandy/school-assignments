/*
 * This code was created by Clinton Rogers for the specific intent of being used by his students.
 * Derivative works based on this code may only be submitted to myCourses, and a copy local to the students
 * own computer. At no time should this code, derivative or otherwise, be shared with other students,
 * people, or posted online.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;


public class TrackGenerator {

	private static Random rand = new Random();

	private static void fill2DArray(char [][]wood)
	{
		//Fill the 2D array 'wood' with non-space characters
		
		for(int x = 0; x<wood.length; x++) {
			for(int y =0; y<wood[x].length;y++)
			{
				//some code to set wood[x][y] to a character
			}
		}
		/*********************************************
		 * TODO FILL IN CODE HERE
		 *********************************************/
		
	
	}
	
	private static void carveTrack(char [][] wood, int x, int y)
	{
		/*********************************************
		 * TODO FILL IN CODE HERE
		 *********************************************/
		
		hasNoNeighbors(wood, x, y) != false  //!hasNoNeighbors(wood, x, y)
				//pick a random direction 0-3
				//can you go that direction?
					//if you can, go that direction
					if(hasEastNeighbor(wood,x, y))
					{
						wood[x+1][y] = ' ';
						wood[x+2][y] = ' ';
						carveTrack(wood,x+2, y));
					}
		
		
	}
	
	private static boolean hasWestNeighbor(char[][] wood, int x, int y)
	{
		return (x-2)>=1 && wood[x-2][y] != ' ';
	}
	
	private static boolean hasEastNeighbor(char[][] wood, int x, int y)
	{
		return (x+2)<wood.length && wood[x+2][y] != ' ';
	}
	
	private static boolean hasNorthNeighbor(char[][] wood, int x, int y)
	{
		return (y-2)>=1 && wood[x][y-2] != ' ';
	}
	private static boolean hasSouthNeighbor(char[][] wood, int x, int y)
	{
		return (y+2)<wood[x].length && wood[x][y+2] != ' ';
	}
	
	private static boolean hasNoNeighbors(char[][] wood, int x, int y)
	{
		return !hasWestNeighbor(wood,x,y) && !hasEastNeighbor(wood,x,y) && !hasNorthNeighbor(wood,x,y) && !hasSouthNeighbor(wood,x,y);
	}
	
	public static void generateMaze(char [][] wood, int x, int y)
	{
		fill2DArray(wood);
		wood[x][y]=' ';
		carveTrack(wood,x,y);
	}

	public static void printMatrix(char [][]matrix, String toFile)
	{
		//if a file name is provided, print to the file
		if(toFile!= "")
		{		
			try{
				
				int count=1;
				String newFileName = toFile+".txt";
				File f = new File(newFileName);
				while(f.exists())
				{
					newFileName = toFile+count+".txt";
					count++;
					f=new File(newFileName);
				}
				
				PrintWriter writer = new PrintWriter(newFileName);
				//Fill matrix with non-space characters
				for(int y=0;y<matrix[0].length;y++)
				{
					for(int x=0;x<matrix.length;x++)
						writer.print(matrix[x][y]);
					writer.println();
				}
				writer.close();
			}catch(Exception e)
			{
				System.out.println("Exception e caught:" + e.getMessage());
			}
		}else //otherwise, print to the screen
		{
			//Fill matrix with non-space characters
			for(int y=0;y<matrix[0].length;y++)
			{
				for(int x=0;x<matrix.length;x++)
					System.out.print(matrix[x][y]);
				System.out.println();
			}
		}
	}
}
