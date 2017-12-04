package impl;

public class Main {

	public static void main(String[] args) {
		ArrayTree<Integer> arraytree = new ArrayTree<Integer>();
		arraytree.add(10);
		arraytree.add(15);
		arraytree.add(9);
		arraytree.add(6);
		arraytree.add(8);
		
		arraytree.prinInOrder();
	}	

}
