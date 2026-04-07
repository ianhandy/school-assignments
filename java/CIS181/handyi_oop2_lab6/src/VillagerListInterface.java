
public interface VillagerListInterface {

    public void add(String name);
    public void remove(String name);
    public boolean isEmpty();
    public boolean isFull();
    public String getItem(int i);
	public int getSize();
	public VillagerListInterface shuffleAndFilter();
    public void printList();
}
