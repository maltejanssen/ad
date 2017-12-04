package impl;

public class Pos<T extends Comparable<T>> {
	
	public Container<T> container;
	public int idx;
	public boolean isValid;
	
	public Pos() {
		container = null;
		idx = 0;
		isValid = false;
	}

}
