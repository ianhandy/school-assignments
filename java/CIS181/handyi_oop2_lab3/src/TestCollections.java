/***********************************************************
 * Name: Ian Handy
 * Date: 3/31/26
 * Description of lab work: Test cases for WyvernSphereCollection
 * methods including remove, union, intersection, and complement.
 ***********************************************************/

public class TestCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] s = {2, 5, 11, 19};
		WyvernSphereCollection is = new WyvernSphereCollection(s);

		int[] t = {1, 6, 7, 10};
        WyvernSphereCollection is2 = new WyvernSphereCollection(t);

		// Test cases

        //Test successfully adding a sphere using addSphere()
		System.out.println("Before insertion: " + is.toString());
		is.addSphere(34);
		System.out.println("After insertion: " + is.toString());

		//Test adding an invalid sphere using addSphere()
		System.out.println("Before insertion: " + is.toString());
		is.addSphere(-88);
		System.out.println("After insertion: " + is.toString());

		//Test removeSphere with valid sphere
		System.out.println("\n--- Testing removeSphere ---");
		System.out.println("Before removal: " + is.toString());
		is.removeSphere(34);
		System.out.println("After removing 34: " + is.toString());

		//Test removeSphere with sphere that doesn't exist
		System.out.println("Trying to remove 99 (not in collection):");
		is.removeSphere(99);

		//Test removeSphere with invalid index
		System.out.println("Trying to remove -5 (invalid):");
		is.removeSphere(-5);

		//Test union
		System.out.println("\n--- Testing union ---");
		System.out.println("Collection 1: " + is.toString());
		System.out.println("Collection 2: " + is2.toString());
		WyvernSphereCollection unionResult = is.union(is2);
		System.out.println("Union: " + unionResult.toString());
		System.out.println("Union count: " + unionResult.getSphereCount());

		//Test intersection
		System.out.println("\n--- Testing intersection ---");
		int[] u = {2, 5, 7, 19};
		WyvernSphereCollection is3 = new WyvernSphereCollection(u);
		System.out.println("Collection 1: " + is.toString());
		System.out.println("Collection 3: " + is3.toString());
		WyvernSphereCollection interResult = is.intersection(is3);
		System.out.println("Intersection: " + interResult.toString());
		System.out.println("Intersection count: " + interResult.getSphereCount());

		//Test intersection with no overlap
		System.out.println("Intersection of is and is2 (no overlap):");
		WyvernSphereCollection noOverlap = is.intersection(is2);
		System.out.println("Result: " + noOverlap.toString());

		//Test complement
		System.out.println("\n--- Testing complement ---");
		System.out.println("Collection: " + is.toString());
		WyvernSphereCollection compResult = is.complement();
		System.out.println("Complement count: " + compResult.getSphereCount());
		System.out.println("Original count + complement count = " + (is.getSphereCount() + compResult.getSphereCount()));
	}

}
