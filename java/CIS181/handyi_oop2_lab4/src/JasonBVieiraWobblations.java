/*
 * Programmer/Student Name: Ian Handy
 * Date: 3/31/26
 * Class Description: Recursive JBV Wobblation simulation that tracks
 * invocation history and returns the wobblation sum.
 *
 * Other Details:
 * Instructor: Clinton Rogers
 * Class: CIS 181
 *
 * This Code and all derivatives are explicitly for this class only. Sharing of code openly online is explicitly forbidden.
 */

public class JasonBVieiraWobblations {

	private int invocations = 0;

	public int getInvocations()
	{
		return this.invocations;
	}

	/*
	 * Precondition: x and y should be 0 or positive
	 *
	 * Postcondition: Print out all Pops, wibbles, wobbles, and shrinks, finally returning the sum of the wobblation
	 */
	public int simulateWobblations(int x, int y)
	{
		invocations++;

		// POP - base case, both x and y are 0
		if (x == 0 && y == 0) {
			System.out.println(" Pop");
			return 0;
		}
		// WIBBLE y - only x is 0
		else if (x == 0) {
			System.out.println(" Wibble y");
			return x + y + simulateWobblations((y / 2) * 3, (y / 2) * 2);
		}
		// WIBBLE x - only y is 0
		else if (y == 0) {
			System.out.println(" Wibble x");
			return x + y + simulateWobblations((x / 2) * 3, (x / 2) * 2);
		}
		// WOBBLE - either x or y is evenly divisible by 6
		else if (x % 6 == 0 || y % 6 == 0) {
			System.out.println(" Wobble");
			return x + y + simulateWobblations(y - 1, x - 1);
		}
		// SHRINK - otherwise
		else {
			System.out.println(" Shrink");
			return x + y + simulateWobblations(x - 1, y - 1);
		}
	}

}
