package impl;
/**
 * 
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @author Arschwolf
 *
 */
public abstract class Tree <T extends Comparable<T>> {
	
	
	Pos<T> root;

	/**
	 * Inserts element T into the tree at the right position according to is value
	 * 
	 * @param element -> Element to add into the tree. Can't be null. 
	 * @return True if item was added; false if element already in tree
	 */
	public boolean add (T element) { //hier implementieren
		return false;
	}
	
	/**
	 * Returns the left child of the parent node (smaller)
	 * 
	 * @param parent -> the parent node to get the child of
	 * @return Left child element; or null if no left child element existent
	 */
	//protected abstract T getLeftChild(T parent);
	protected abstract Pos<T> getLeftChild(Pos<T> parent);
	
	protected abstract T retrieve(Pos<T> p);
	/**
	 * Returns the right child of the parent node (bigger)
	 * 
	 * @param parent -> the parent node to get the child of
	 * @return Right child element; or null if no right child element existent
	 */
	//protected abstract T getRightChild(T parent);
	protected abstract Pos<T> getRightChild(Pos<T> parent);
	
	/**
	 * Returns the root element of the tree
	 * 
	 * @return Root element if existent; else null
	 */
	public Pos<T> getRoot(){
		return root;
	}
	
}	
	/**
	 * Searches element searched for
	 * 
	 * @return elements searched for; if not existent null
	 */
//	public T find(T comparator){
//		T node = getRoot();
//		while(node != null){
//			if(node.compareTo(comparator) > 0)
//				node = getLeftChild(node);
//			else if(node.compareTo(comparator) < 0)
//				node = getRightChild(node);
//			else break;
//		}
//		return node;
//	}
	
	
//	//auf Pos umstellen
//	public void prinInOrder() {
//		List<T> l = inOrderRec(getRoot());
//		for (T elem: l) {
//			System.out.println(elem);
//		}
//	}
//	
//	private List<T> inOrderRec(T root) {
//		List<T> l = new LinkedList<T>();
//		if (root != null) {
//			l.addAll(inOrderRec(getLeftChild(root)));
//			l.add(root);
//			l.addAll(inOrderRec(getRightChild(root)));
//		}
//		return l;
//	}
//	
//	public void printPostOrder() {
//		List<T> l = postOrderRec(getRoot());
//		for (T elem: l) {
//			System.out.println(elem);
//		}
//	}
//
//	private List<T> postOrderRec(T root) {
//		List<T> l = new LinkedList<T>();
//		if (root != null) {
//			l.addAll(postOrderRec(getLeftChild(root)));
//			l.addAll(postOrderRec(getRightChild(root)));
//			l.add(root);
//		}
//		return l;
//	}
//	
//	public void printPreOrder() {
//		List<T> l = preOrderRec(getRoot());
//		for (T elem: l) {
//			System.out.println(elem);
//		}
//	}
//	
//	private List<T> preOrderRec(T root) {
//		List<T> l = new LinkedList<T>();
//		if (root != null) {
//			l.add(root);
//			l.addAll(preOrderRec(getLeftChild(root)));
//			l.addAll(preOrderRec(getRightChild(root)));
//		}
//		return l;
//	}
//}
