package impl;

import java.util.Arrays;

import pivot.pivotSucher;

public class Quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public Element[] fillArray(int size){
		Element[] array = new Element[size];
		for (int i = 0; i<= size; i++) {
			array[i] = new Element((int)(100*Math.random()));
		}
		return array;
	}
	
	public Element[] quicksort(Element[] array, pivotSucher pivotSucher) {
		
		int p = pivotSucher.getPivotElement(array);
		int i = 0;
		int j = array.length-1;
		
		while (i <= j) {
			while (array[i].getKey() < array[p].getKey()) {
				i++;
			}
			while (array[j].getKey() >= array[p].getKey()) {
				if(j==0)
					break;
				j--;
			}
			if(i>=j) break;
			exchange(array , i , j);
			i++;
			j--;
		}	
		exchange(array, i, p);
		
		Element[] F1 = new Element[array.length-i];
		System.arraycopy(array, 0, F1, 0, (array.length-i));
		
		int F2Size = array.length-F1.length-1;
		if(F2Size < 0)
			F2Size = 0;
		Element[] F2 = new Element[F2Size];
		System.arraycopy(array, i+1, F2, 0, array.length-F1.length-1);
		
		Element[] pArray = {array[p]};
		return concatArrays((concatArrays(quicksort(F1, pivotSucher), pArray)), quicksort(F2, pivotSucher));
		}

	
	public void exchange(Element[] array, int idx1, int idx2){
		Element temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	
	public static Element[] concatArrays(Element[] F1, Element[] F2) {
        Element[] result = Arrays.copyOf(F1, F1.length + F2.length);
        System.arraycopy(F2, 0, result, F1.length, F2.length);
        return result;
    }

}
