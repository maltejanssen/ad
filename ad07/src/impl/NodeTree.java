package impl;

public class NodeTree<T extends Comparable<T>> extends Tree<T> {

	Container<T> root;
	
	@Override
	public boolean add(T element) {
		if (element == null) {
			throw new IllegalArgumentException("item must not be null");
		}
		if(root==null){
			root = new Container<T>(element);
		}
		else {
			if (!find(element)) {
				add(root,element);
				return true;
			}
		}
		return false;
		
//		T elem = root.getData();
//		
//		int comp = element.compareTo(elem);
//		if (comp < 0) {
//			if( leftChild != null ) {
//				return leftChild.insert(item);
//			}
//		}
//		
//		
//		return false;
	}
	
	private void add(Container<T> parent , T element) {
		if (element.compareTo(parent.getData()) > 0) {
			if(parent.getRightChildNode() == null) {
				Container<T> temp = new Container<T>(element, parent);
				parent.setRightChildNode(temp);
			}
			else {
				add (parent.getRightChildNode(),element);
			}	
		}else if (element.compareTo(parent.getData()) < 0) {
			if(parent.getLeftChildNode() == null) {
				Container<T> temp = new Container<T>(element, parent);
				parent.setLeftChildNode(temp);
			}
			else {
				add (parent.getLeftChildNode(),element);
			}
		}
	}

	@Override
	public T getLeftChild(T parent) {
		if (parent == null) {
			throw new IllegalArgumentException("item must not be null");
		}
		Container<T> node = findNode(parent, this.root);
		if (node != null && node.getLeftChildNode() != null) {
			return node.getLeftChildNode().getData();
		}	
		return null;
	}

	@Override
	public T getRightChild(T parent) {
		if (parent == null) {
			throw new IllegalArgumentException("item must not be null");
		}
		Container<T> node = findNode(parent, this.root);
		if (node != null && node.getRightChildNode() != null) {
			return node.getRightChildNode().getData();
		}
		return null;
	}

	@Override
	public T getRoot() {
		return root.getData();
	}
	
	private Container<T> findNode(T value, Container<T> root){
		if(root==null){
			return  null;
		}
		
		if( root.getData().equals(value)){
			return root;
		}
		
		Container<T> l = findNode(value, root.getLeftChildNode());
		Container<T> r = findNode(value, root.getRightChildNode());
		
		if(l!=null){
			return l;
		}
		
		return  r;
	}
		
}


