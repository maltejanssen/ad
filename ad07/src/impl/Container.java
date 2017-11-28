package impl;

public class Container<T extends Comparable<T>> {

	// dataobject
	private T element;
	
	// fields for the linked implementation 
	private Container<T> parentNode;
	private Container<T> leftChildNode;
	private Container<T> rightChildNode;
	
	// fields for the array implementation
	private int parentIdx;
	private int leftChildIdx;
	private int rightdChildIdx;
	
	
	public Container(T element){
		this.element = element;
	}

	
	public Container(T element, Container<T> parentNode) {
		this.element = element;
		this.parentNode = parentNode;
	}
	
	public T retrieve(Pos<T> p) {
		return p.container.getElement();
	}
	
	public Container(T element, int parentIdx) {
		this.element = element;
		this.parentIdx = parentIdx;
	}

	public Container<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Container<T> parent) {
		this.parentNode = parent;
	}

	public Container<T> getLeftChildNode() {
		return leftChildNode;
	}

	public void setleftChildNode(Container<T> leftChild) {
		this.leftChildNode = leftChild;
	}

	public Container<T> getRightChildNode() {
		return rightChildNode;
	}

	public void setRightChildNode(Container<T> rightChild) {
		this.rightChildNode = rightChild;
	}

	public T getElement() {
		return element;
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
		return rightdChildIdx;
	}

	/**
	 * @param secondChildIdx the secondChildIdx to set
	 */
	public void setRightChildIdx(int rightChildIdx) {
		this.rightdChildIdx = rightChildIdx;
	}

	/**
	 * @return the firstChildIdx
	 */
	public int getLeftChildIdx() {
		return leftChildIdx;
	}

	/**
	 * @param firstChildIdx the firstChildIdx to set
	 */
	public void setLeftChildIdx(int leftChildIdx) {
		this.leftChildIdx = leftChildIdx;
	}
}
