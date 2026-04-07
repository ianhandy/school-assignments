import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//Names to test
		String[] names = ListOfNames.names;

		Random rand = new Random();			//random
		VillagerListInterface simpleList = new MyAnimalCrossingVillagerList();	//new MyAnimalCrossingVillagerList

		//tests
		addNames(names, simpleList);

		System.out.println("\nPrinting Island Residents!\n");
		simpleList.printList();
		System.out.println("\nRemoving Boss");
		simpleList.remove("Boss");

		System.out.println("Adding Paddy...");
		simpleList.add("Paddy");

		System.out.println("\nPrinting Island Residents!\n");
		simpleList.printList();

		System.out.println("\nRemoving Paddy from list!\n");
		simpleList.remove("Paddy");

		simpleList.printList();
		simpleList = simpleList.shuffleAndFilter();
		System.out.println("\nShuffling and filtering: ");
		simpleList.printList();

		System.out.println("\nPrinting Island Residents!\n");
		simpleList.printList();


		System.out.println("\nShuffling and filtering and reprinting Island Residents:");
		simpleList = simpleList.shuffleAndFilter();
		simpleList.printList();
	}

	public static void addNames(String[] n, VillagerListInterface a)
	{
		for(int i = 0; i < n.length; i++)
		{
			a.add(n[i]);
		}
	}

}
