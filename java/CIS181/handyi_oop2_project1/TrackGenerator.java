/*
 * This code was created by Clinton Rogers for the specific intent of being used by his students.
 * Derivative works based on this code may only be submitted to myCourses, and a copy local to the students
 * own computer. At no time should this code, derivative or otherwise, be shared with other students,
 * people, or posted online.
 */

/*
 * Name: Ian Handy
 * Date: 3/24/2026
 * Description: TrackGenerator is responsible for generating a random maze (track) inside a 2D
 * character array. It fills the array with wall characters to represent raw wood, then recursively
 * carves out paths using a backtracking algorithm -- similar to how a RoboRodent would chew
 * through a block of wood randomly until it runs out of places to go.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;


public class TrackGenerator {

	private static Random rand = new Random();

	// Fills the entire 2D array with '#' characters to represent a solid block of wood.
	// Every cell starts as a wall -- carveTrack will open up spaces later.
	private static void fill2DArray(char [][]wood)
	{
		for(int x = 0; x < wood.length; x++) {
			for(int y = 0; y < wood[x].length; y++)
			{
				wood[x][y] = '#';
			}
		}
	}

	// Recursively carves a path through the wood starting at position (x, y).
	// At each step, a random direction is chosen. If the robot can move that way
	// (meaning it won't carve into an already-open tunnel), it carves through two
	// cells in that direction and recursively continues from the new position.
	// If it can't move anywhere, it just returns -- this is the backtracking step.
	private static void carveTrack(char [][] wood, int x, int y)
	{
		// keep carving as long as there's somewhere new to go
		while(!hasNoNeighbors(wood, x, y))
		{
			// pick a random direction: 0=north, 1=south, 2=east, 3=west
			int direction = rand.nextInt(4);

			if(direction == 0 && hasNorthNeighbor(wood, x, y))
			{
				// carve north: remove the wall between current and target, then the target cell
				wood[x][y-1] = ' ';
				wood[x][y-2] = ' ';
				carveTrack(wood, x, y-2);
			}
			else if(direction == 1 && hasSouthNeighbor(wood, x, y))
			{
				// carve south
				wood[x][y+1] = ' ';
				wood[x][y+2] = ' ';
				carveTrack(wood, x, y+2);
			}
			else if(direction == 2 && hasEastNeighbor(wood, x, y))
			{
				// carve east
				wood[x+1][y] = ' ';
				wood[x+2][y] = ' ';
				carveTrack(wood, x+2, y);
			}
			else if(direction == 3 && hasWestNeighbor(wood, x, y))
			{
				// carve west
				wood[x-1][y] = ' ';
				wood[x-2][y] = ' ';
				carveTrack(wood, x-2, y);
			}
			// if the randomly picked direction wasn't valid, the loop just tries again
		}
		// no neighbors left -- backtrack by returning
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
