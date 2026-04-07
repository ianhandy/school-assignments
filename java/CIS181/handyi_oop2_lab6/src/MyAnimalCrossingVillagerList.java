/***********************************************************
 * Name: Ian Handy
 * Date: 3/31/26
 * Description of lab work: Array-based implementation of
 * the MyAnimalCrossingVillagerList ADT using an interface.
 ***********************************************************/

public class MyAnimalCrossingVillagerList implements VillagerListInterface
{
    //internal list of size 5000
	private static final int ARRAY_SIZE = 5000;
    private String[] list = new String[ARRAY_SIZE];

    //current count of items in the list
	private int count = 0;

	public MyAnimalCrossingVillagerList()
	{
        System.out.println("A new villager list has been created!");
        // set every element to empty string
        for (int i = 0; i < list.length; i++) {
            list[i] = "";
        }
	}

    public void add(String name)
    {
        // check if the island is full
        if (count == list.length) {
            System.out.println("The island is full!");
            return;
        }

    	// make sure name is not empty
    	if (name.equals("")) {
    	    System.out.println("That is not a valid name!");
    	    return;
    	}

    	// add name to the next available spot
    	list[count] = name;
    	count++;
    }

	public int getSize() {
		return count;
	}

    public void remove(String name)
    {
        for (int i = 0; i < count; i++) {
            if (list[i].compareToIgnoreCase(name) == 0) {
                // replace with last item and decrease count
                list[i] = list[count - 1];
                list[count - 1] = "";
                count--;
                return;
            }
        }
        System.out.println(name + " already does not live on the island!");
	}

    public boolean isEmpty()
    {
		return count == 0;
	}

    public boolean isFull()
    {
		return count == list.length;
	}

    public String getItem(int i)
    {
        if (i < 0 || i >= count) {
            System.out.println("That character does not live here");
            return "";
        }
        return list[i];
	}

	public VillagerListInterface shuffleAndFilter() {
        VillagerListInterface temp = new MyAnimalCrossingVillagerList();

        // start at the end, add every other name going backwards
        for (int x = count - 1; x >= 0; x--) {
            temp.add(list[x]);
        }

        return temp;
	}

    public void printList()
    {
        for (int i = 0; i < count; i++) {
            System.out.println(list[i]);
        }
    }

}
