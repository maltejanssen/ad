package impl;
import java.util.concurrent.ThreadLocalRandom;

public class Quicksort {

	public enum pivotSucher {
		LAST_ELEMENT, RANDOM, MEDIAN
	}
	
	Element[] _array;
	pivotSucher _pivotSucher;

	public Quicksort(Element[] array, pivotSucher p) {
		_array = array;
		_pivotSucher = p;
	}

	public Class<? extends pivotSucher> whichPivotSucher() {
		return _pivotSucher.getClass();
	}

	// public Element[] fillArray(int size) {
	// Element[] array = new Element[size];
	// for (int i = 0; i <= size; i++) {
	// array[i] = new Element((int) (100 * Math.random()));
	// }
	// return array;
	// }

	// public Element[] quicksort(pivotSucher pivotSucher) {
	//
	// int p = pivotSucher.getPivotElement(array);
	// int i = 0;
	// int j = array.length - 1;
	//
	// while (i <= j) {
	// while (array[i].getKey() < array[p].getKey()) {
	// i++;
	// }
	// while (array[j].getKey() >= array[p].getKey()) {
	// if (j == 0)
	// break;
	// j--;
	// }
	// if (i >= j)
	// break;
	// exchange(array, i, j);
	// i++;
	// j--;
	// }
	// exchange(array, i, p);
	// return array;
	//
	// }
	public Element[] doQuicksort() {
		doQuicksortInterna(0, _array.length-1);
		return _array;
	}

	private void doQuicksortInterna(int ilinks, int irechts) {
		int pivot, i, j;
		
		if (irechts > ilinks) {
			i = ilinks;
			j = irechts - 1;
			pivot = _array[getPivotElement(ilinks, irechts)].getKey();
			while (true) {
				while (_array[i].getKey() < pivot)
					i++;
				while (_array[j].getKey() > pivot && (getPivotElement(ilinks, irechts) != irechts))
					j--;// Vorsicht: Stop-Element einbauen
				if (i >= j)
					break;// in der Mitte getroffen
				exchange(i, j);// vertauschen
			}
			exchange(i, irechts);// Pivotelement in die Mitte tauschen
			doQuicksortInterna(ilinks, i - 1);
			doQuicksortInterna(i + 1, irechts);
		}
	}

	public void exchange(int idx1, int idx2) {
		Element temp = _array[idx1];
		_array[idx1] = _array[idx2];
		_array[idx2] = temp;
	}

	private int getPivotElement(int ilinks, int irechts) {
		
		switch (_pivotSucher) {

		case LAST_ELEMENT:
			return getPivotLastElement(ilinks, irechts);
		case MEDIAN:
			return getPivotMedian(ilinks, irechts);
		case RANDOM:
			return getPivotRandom(ilinks, irechts);
		default:
			return ilinks;
		}
	}

	private int getPivotLastElement(int ilinks, int irechts) {
		return irechts;
	}

	private int getPivotRandom(int ilinks, int irechts) {
		return ThreadLocalRandom.current().nextInt(ilinks, irechts + 1);
	}

	private int getPivotMedian(int ilinks, int irechts) {
		int a = _array[ilinks].getKey();
		int b = _array[ilinks + (irechts - ilinks) / 2].getKey();
		int c = _array[irechts].getKey();
		if (a < c && a > b) {
			return ilinks;
		}
		if (a > c && a < b) {
			return ilinks;
		}
		if (c < a && c > b) {
			return irechts;
		}
		if (c > a && c < b) {
			return irechts;
		}
		if (b < a && b > c) {
			return ilinks + (irechts - ilinks) / 2;
		}
		if (b > a && b < c) {
			return ilinks + (irechts - ilinks) / 2;
		} else {
			return ilinks;
		}
	}


}
