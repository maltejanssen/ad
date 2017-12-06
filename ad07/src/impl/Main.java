package impl;

public class Main {

	public static void main(String[] args) {
		ArrayTree<Character> arraytree = new ArrayTree<Character>();
		arraytree.add('F');
		arraytree.add('B');
		arraytree.add('G');
		arraytree.add('A');
		arraytree.add('D');
		arraytree.add('C');
		arraytree.add('E');
		arraytree.add('I');
		arraytree.add('H');
		
		
		arraytree.printInOrder();
		
		NodeTree<Character> nodetree = new NodeTree<Character>();
		nodetree.add('F');
		nodetree.add('B');
		nodetree.add('G');
		nodetree.add('A');
		nodetree.add('D');
		nodetree.add('C');
		nodetree.add('E');
		nodetree.add('I');
		nodetree.add('H');
		
		
		nodetree.printInOrder();
	}	

}
