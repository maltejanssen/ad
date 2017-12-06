package impl;

public class ArrayTree<T extends Comparable<T>> extends Tree<T> {

	//private T[] array;
	Comparable<T>[] array;
	
	
	private int[] indCache = {0,0,0,0,0};
	private int indCachePos = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayTree() {
		//array = (T[]) new Object[10];
		array = new Comparable[10];
	}
	
	@Override
	public boolean add(T element) {
		if (element == null) {
			throw new IllegalArgumentException("item must not be null");
		}
		int idx = findInsertionIdx(element);
		
		if (idx == 0) {
			return false;
		}	
		array[idx] = element;
		return true;
	}
	
	private int findInsertionIdx(T element) {
		int idxParent = 1;
		int idxLeft;
		int idxRight;
		
		while(array[idxParent] != null) {
			idxLeft = getLeftChildIdx(idxParent);
			idxRight = getRightChildIdx(idxParent);

			int cmp = element.compareTo((T) array[idxParent]);
			if (cmp < 0) {
				if (array[idxLeft] == null) {
					return idxLeft;
				} else {
					idxParent = idxLeft;
				}
			} else if (cmp > 0) {
				if (array[idxRight] == null) {
					return idxRight;
				} else {
					idxParent = idxRight;
				}
			} else
				return 0;
		}
		return idxParent;	
	}
	
	private int getLeftChildIdx(int parentIdx) {
		if (parentIdx < 1) {
			return 0;
		}
		else {
			int newIdx = 2*parentIdx;
			if (newIdx >= array.length) {
				enlargeArray();
			}
			return newIdx;
		}
		
	}

	private int getRightChildIdx(int parentIdx) {
		if (parentIdx < 1) {
			return 0;
		}
		else {
			int newIdx = 2*parentIdx+1;
			if (newIdx >= array.length) {
				enlargeArray();
			}
			return newIdx;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void enlargeArray() {
		int length = array.length;
//		Object[] tmpArray = new Object[length*2];
//		System.arraycopy(array, 0, tmpArray, 0, array.length);
//		array = (T[]) tmpArray;
		Comparable<T>[] tmpArray = new Comparable[length*2];
		System.arraycopy(array, 0, tmpArray, 0, array.length);
		array = tmpArray;
	}

	@Override
	public T getLeftChild(T parent) {
		if (parent == null) {
			throw new IllegalArgumentException("parent must not be null");
		}
		int idx = getLeftChildIdx(getIndexOf(parent));
		//System.out.println(idx);
		if (idx > 0) {
			return (T) array[idx];
		}
		else {
			return null;
		}
	}
	
	@Override
	public T getRightChild(T parent) {
		if (parent == null) {
			throw new IllegalArgumentException("parent must not be null");
		}
		int idx = getRightChildIdx(getIndexOf(parent));
		//System.out.println(idx);
		if (idx > 0) {
			return (T) array[idx];
		}
		else {
			return null;
		}
	}
	
	
	
	private int getIndexOf(T item) {
		int idx = -1;
		for (int i = 1; (i < array.length) && (idx == -1); i++) {
	        if (array[i] != null) {
	        	if (array[i].compareTo(item) == 0) {
	        	  	idx = i;
		            return idx;
	        	}
	        }
	    }
		return idx;

	}
	
	@Override
	public T getRoot() {
		return (T) array[1];
	}

}
