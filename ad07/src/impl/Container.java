package impl;

public class Container {

	// dataobject
	private Object data;
	
	// fields for the linked implementation 
	private Container parentNode;
	private Container firstChildNode;
	private Container secondChildNode;
	
	// fields for the array implementation
	private int parentIdx;
	private int firstChildIdx;
	private int secondChildIdx;
	
	
	public Container(Object data){
		this.data = data;
	}
	
	public Container(Object data, Container parentNode) {
		this.data = data;
		this.parentNode = parentNode;
	}
	
	public Container(Object data, int parentIdx) {
		this.data = data;
		this.parentIdx = parentIdx;
	}

	public Container getParentNode() {
		return parentNode;
	}

	public void setParentNode(Container parent) {
		this.parentNode = parent;
	}

	public Container getFirstChildNode() {
		return firstChildNode;
	}

	public void setFirstChildNode(Container firstChild) {
		this.firstChildNode = firstChild;
	}

	public Container getSecondChildNode() {
		return secondChildNode;
	}

	public void setSecondChildNode(Container secondChild) {
		this.secondChildNode = secondChild;
	}

	public Object getData() {
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
