package impl;

public class Main {

	public static void main(String[] args) {
		NodeTree<Integer> nodetree = new NodeTree<Integer>();
		nodetree.add(10);
		nodetree.add(5);
		nodetree.add(3);
		nodetree.add(12);
		
		nodetree.prinInOrder();

	}

}
