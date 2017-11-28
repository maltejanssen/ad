package impl;

public class Container<T extends Comparable<T>> {

	// dataobject
	private T data;
	
	// fields for the linked implementation 
	private Container<T> parentNode;
	private Container<T> leftChildNode;
	private Container<T> rightChildNode;
	
	// fields for the array implementation
	private int parentIdx;
	private int firstChildIdx;
	private int secondChildIdx;
	
	
	public Container(T data){
		this.data = data;
	}
	
	public Container(T data, Container<T> parentNode) {
		this.data = data;
		this.parentNode = parentNode;
	}
	
	public Container(T data, int parentIdx) {
		this.data = data;
		this.parentIdx = parentIdx;
	}

	public Container<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Container<T> parent) {
		this.parentNode = parent;
	}

	public Container<T> getFirstChildNode() {
		return firstChildNode;
	}

	public void setFirstChildNode(Container<T> firstChild) {
		this.firstChildNode = firstChild;
	}

	public Container<T> getSecondChildNode() {
		return rightChildNode;
	}

	public void setSecondChildNode(Container<T> secondChild) {
		this.rightChildNode = secondChild;
	}

	public T getData() {
		return data;
	}

	/**
	 * @return the parentIdx
	 */
	public int getParentIdx() {
		return parentIdx;
	}

	/**
	 * @param parentIdx the parentIdx to set
	 */
	public void setParentIdx(int parentIdx) {
		this.parentIdx = parentIdx;
	}

	/**
	 * @return the secondChildIdx
	 */
	public int getSecondChildIdx() {
		return secondChildIdx;
	}

	/**
	 * @param secondChildIdx the secondChildIdx to set
	 */
	public void setSecondChildIdx(int secondChildIdx) {
		this.secondChildIdx = secondChildIdx;
	}

	/**
	 * @return the firstChildIdx
	 */
	public int getFirstChildIdx() {
		return firstChildIdx;
	}

	/**
	 * @param firstChildIdx the firstChildIdx to set
	 */
	public void setFirstChildIdx(int firstChildIdx) {
		this.firstChildIdx = firstChildIdx;
	}
}
