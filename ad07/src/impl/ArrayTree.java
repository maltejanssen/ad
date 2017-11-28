package impl;

public class ArrayTree<T extends Comparable<T>> extends Tree<T> {

	private Container[] arrayTree;
	
	public ArrayTree() {
		arrayTree = new Container[15];
	}
	
	@Override
	public boolean add(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getLeftChild(T parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getRightChild(T parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
