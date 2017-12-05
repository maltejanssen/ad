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
	
	public Pos(int idx) {
		container = null;
		this.idx = idx;
		isValid = true;
	}
	
	public Pos(Container<T> cont) {
		container = cont;
		idx = 0;
		isValid = true;
	}
	
	public void setInvalid() {
		isValid = false;
	}
	
	public boolean isValid() {
		return isValid;
	}

}
