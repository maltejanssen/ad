package impl;

public class ArrayTree<T extends Comparable<T>> extends Tree<T> {

	private T[] arrayTree;
	
	@SuppressWarnings("unchecked")
	public ArrayTree() {
		arrayTree = (T[]) new Object[10];
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
