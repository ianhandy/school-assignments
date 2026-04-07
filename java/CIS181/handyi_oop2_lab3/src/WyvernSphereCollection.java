/***********************************************************
 * Name: Ian Handy
 * Date: 3/31/26
 * Description of lab work: Implementing set operations for
 * WyvernSphereCollection using boolean arrays.
 ***********************************************************/

public class WyvernSphereCollection {

    //Attributes
    private boolean[] collection = new boolean[100];
    private int count = 0; //maintains the number of elements in the set

    //Constructors

    //Postcondition: Creates an empty collection, count==0
    public WyvernSphereCollection(){
	    //all variables set when object is created
    	count = 0;

    	//Make sure our collection is empty, we have no spheres yet
    	for(int index = 0; index<collection.length; index++)
    	{
    		collection[index] = false;
    	}
    }

    //Precondition: every element of values has the property 0<=element<=99
    //Postcondition: For all x in values, such that 0<=x<=100, contents[x]==true.
    public WyvernSphereCollection(int[] values){

    	//For each int we are given in the array values
	    for (int i = 0; i < values.length; i++) {
	    	int asteriskNumber = values[i];

	    	//make sure it's a valid index for the array collection
		    if (asteriskNumber>=0 && asteriskNumber< collection.length ) {
			    collection[asteriskNumber] = true;
			    count++;
		    }
	    }
    }

    //Set Methods

    /**
     * Precondtion: null
     * Postcondition: return this.count==0
     */
    public boolean isEmpty(){
	    return this.count == 0;
    }

    /**
     * Precondition: null
     * Postcondition: return this.count
     */
    public int getSphereCount(){
         return this.count;
    }

    /**
     * Precondition: 0<=element<collection.length
     * Postcondition: return this.collection[asteriskNumber]
     */
    public boolean hasSphere(int asteriskNumber){
    	//make sure the the asteriskNumber is between 0 and 99 inclusive
	    if (asteriskNumber >= 0 && asteriskNumber <= collection.length) {
		    return this.collection[asteriskNumber];
	    } else {
		    return false;
	    }
    }

    /**
     * Precondition: 0<=element<collection.length and !this.hasSphere(asteriskNumber)
     * Postcondition: this.contents[element] = true.  returns true if successful,
     *                false otherwise
     *
     */
    public boolean addSphere(int asteriskNumber){

	    if ((asteriskNumber <collection.length && asteriskNumber >= 0) && !this.hasSphere(asteriskNumber)) {
		    this.collection[asteriskNumber] = true;
		    this.count++;
		    return true;	//added successfully
	    } else {
	    	System.out.println("Precondition is NOT satisfied: element = " + asteriskNumber);
		    return false; 	//not added
	    }
    }

    /**
     * Precondition: 0<=asteriskNumber AND asteriskNumber<collection.length AND this.hasSphere(asteriskNumber)
     * Postcondition: this.contents[element] = false. returns true if successful,
     *                false otherwise
     *
     */
    public boolean removeSphere(int asteriskNumber){

    	// check that the asteriskNumber is valid and we actually have it
    	if ((asteriskNumber >= 0 && asteriskNumber < collection.length) && this.hasSphere(asteriskNumber)) {
    		this.collection[asteriskNumber] = false;
    		this.count--;
    		return true;
    	} else {
    		System.out.println("Precondition is NOT satisfied: element = " + asteriskNumber);
    		return false;
    	}
    }

    //Operations

    /**
     * Precondition: differentCollection is a different WyvernSphereCollection instance.
     * Postcondition: returns a new collection that is the union of this collection and differentCollection
     */
    public WyvernSphereCollection union(WyvernSphereCollection differentCollection){
    	WyvernSphereCollection newCollection = new WyvernSphereCollection();

    	// union means if either collection has the sphere, include it
    	for (int i = 0; i < collection.length; i++) {
    		if (this.collection[i] || differentCollection.hasSphere(i)) {
    			newCollection.addSphere(i);
    		}
    	}

    	return newCollection;
    }

    /**
     * Precondition: differentCollection is a different WyvernSphereCollection instance.
     * Postcondition: returns a new collection that is the intersection of this collection and differentCollection
     */
    public WyvernSphereCollection intersection(WyvernSphereCollection differentCollection){
    	WyvernSphereCollection newCollection = new WyvernSphereCollection();

    	// intersection means both collections must have the sphere
    	for (int i = 0; i < collection.length; i++) {
    		if (this.collection[i] && differentCollection.hasSphere(i)) {
    			newCollection.addSphere(i);
    		}
    	}

    	return newCollection;
    }

    /**
     * Precondition: none
     * Postcondition: produces a new collection representing those elements that are in
     *            a complete collection but not in this collection. The collection is unchanged.
     */
    public WyvernSphereCollection complement(){
    	WyvernSphereCollection newCollection = new WyvernSphereCollection();

    	// complement means everything we DON'T have
    	for (int i = 0; i < collection.length; i++) {
    		if (!this.collection[i]) {
    			newCollection.addSphere(i);
    		}
    	}

    	return newCollection;
    }

    //Utilities

    /**
     * Postcondition: returns a String representation of the collection. The
     *  representation is {int, int, int} beginning with the smallest value
     *  in the set to the largest from left to right.
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("{");

        for (int i = 0; i <collection.length; i++) {
      	    if (this.collection[i]) {
      	 	    s.append(i + " asterisk sphere, ");
      	    }
        }

        //remove the last "," and white space from the end of the stringbuffer
        if (s.length() > 1) {
      	    s.delete(s.length()-2, s.length());
        }
        s.append("}");

        return s.toString();
    }
}
