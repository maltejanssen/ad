package impl;
public class NodeTree<T extends Comparable<T>> extends Tree<T> {

	Container<T> root; 
	
	public NodeTree(Container<T> root) {
		root = null;
	}
	
	@Override
	public boolean add(T element) {
		
		if (root == null) {
			root = new Container<T>(element);
			root.setParentNode(null);
			return true;
		}
		T elem = root;
		int comp = elem.compareTo(element);
		
		if (comp < elem && !null) {
			setLeftChild.add(element)
		}
		
		if (comp > elem) {
			setRightChild.add(element)
		}
		
		
		element.compareTo(comp)
				
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
		return root.getData();
	}

}
