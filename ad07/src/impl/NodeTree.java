package impl;
public class NodeTree<T extends Comparable<T>> extends Tree<T> { 
	
	public NodeTree() {
		
	}
	
//	@Override
//	public boolean add(T element) {
//		
//		if (root == null) {
//			root = new Container<T>(element);
//			root.setParentNode(null);
//			return true;
//		}
//		T elem = root;
//		int comp = elem.compareTo(element);
//		
//		if (comp < elem && !null) {
//			setLeftChild.add(element)
//		}
//		
//		if (comp > elem) {
//			setRightChild.add(element)
//		}
//		
//		
//		element.compareTo(comp)
//				
//		return false;
//	}

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
