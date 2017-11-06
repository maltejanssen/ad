package ad05;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public enum Verfahren{
		MODEA,
		MODEB,
		MODEC
	}
	
	public Element[] fillArray(int size){
		Element[] array = new Element[size];
		for (int i = 0; i<= size; i++) {
			array[i] = new Element();
		}
		return array;
	}
	
	public Element[] quicksort(Element[] array, Verfahren v) {
		Element pivotElement = null;
		switch(v) {
			case MODEA:
				pivotElement = modeA(array);
				break;
			case MODEB:
				pivotElement = modeB(array);
				break;
			case MODEC:	
				pivotElement = modeC(array);
				break;
		}
		int i = 0;
		int j = array.length-1;
		
		while (i <= j) {
			while (array[i].getKey() < pivotElement.getKey()) {
				i++;
			}
			while (array[j].getKey() > pivotElement.getKey()) {
				j--;
			}
			exchange(array , i , j);
			i++;
			j--;
		}	
		quicksort(array);
		quicksort(array);
		}

	
	public void exchange(Element[] array, int idx1, int idx2){
		Element temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	
	public Element modeA(Element[] array) {
		return array[array.length-1];
	}
	
	public Element modeB(Element[] array) {
		if ( array[0].getKey() < array[array.length-1].getKey() &&  array[0].getKey() > array[(array.length-1)/2].getKey()) {
			return array[array[0].getKey()];
		}
		if ( array[0].getKey() > array[array.length-1].getKey() &&  array[0].getKey() < array[(array.length-1)/2].getKey()) {
			return array[array[0].getKey()];
		}
		if ( array[array.length-1].getKey() < array[0].getKey() &&  array[array.length-1].getKey() > array[(array.length-1)/2].getKey()) {
			return array[array.length-1];
		}
		if ( array[array.length-1].getKey() > array[0].getKey() &&  array[array.length-1].getKey() < array[(array.length-1)/2].getKey()) {
			return array[array.length-1];
		}
		if ( array[(array.length-1)/2].getKey() < array[0].getKey() && array[(array.length-1)/2].getKey() > array[array.length-1].getKey()) {
			return array[(array.length-1)/2];
		}
		if ( array[(array.length-1)/2].getKey() > array[0].getKey() && array[(array.length-1)/2].getKey() < array[array.length-1].getKey()) {
			return array[(array.length-1)/2];
		}
		else {
			return null;
		}	
	} 
	
	public Element modeC(Element[] array) {
		return array[(int)((array.length-1) * Math.random())];
	}

}
