package impl;

public class ArrayTree<T extends Comparable<T>> extends Tree<T> {

	private T[] arrayTree;
	
	@SuppressWarnings("unchecked")
	public ArrayTree() {
		arrayTree = (T[]) new Object[10];
	}
	

	@Override
	public Pos<T> getLeftChild(Pos<T> parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pos<T> getRightChild(Pos<T> parent) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected T retrieve(Pos<T> p) {
		// TODO Auto-generated method stub
		return null;
	}
}
