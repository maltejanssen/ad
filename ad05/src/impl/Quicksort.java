package impl;

import java.util.concurrent.ThreadLocalRandom;

import impl.Quicksort.pivotSucher;

public class Quicksort {

	public static void main(String[] args)
	{
		for(int i = 1; i <= 10000; i*=10)
		{
			Element[] array = fillArray(i);
			Quicksort QS;
			QS = new Quicksort(array, pivotSucher.LAST_ELEMENT);
			
		}
		
		
		
	}
	
	public enum pivotSucher {
		LAST_ELEMENT, RANDOM, MEDIAN,
	}

	Element[] _array;
	pivotSucher _pivotSucher;
	private int _counterOperations;
	private int _counterCompares;

	public Quicksort(Element[] array, pivotSucher p) {
		_array = array;
		_pivotSucher = p;
		_counterOperations = 0;
		_counterCompares = 0;
	}

	public pivotSucher whichPivotSucher() {
		return _pivotSucher;
	}

	public static Element[] fillArray(int size) {
		Element[] array = new Element[size];
		for (int i = 0; i <= size; i++) {
			array[i] = new Element((int) (size * Math.random()));
		}
		return array;
	}

	public Element[] doQuicksort() {
		doQuicksortInterna(0, _array.length - 1);
		return _array;
	}

	private void doQuicksortInterna(int ilinks, int irechts) {
		int pivot, i, j, pivotIdx;

		if (irechts > ilinks) {
			i = ilinks;
			j = irechts;
			pivot = _array[getPivotElement(ilinks, irechts)].getKey();
			pivotIdx = getPivotElement(ilinks, irechts);
			while (true) {
				while (_array[i].getKey() < pivot)
					i++;
				while (_array[j].getKey() >= pivot) {
					j--;// Vorsicht: Stop-Element einbauen
					if (j <= ilinks)
						break;
				}
				if (i >= j)
					break;// in der Mitte getroffen
				exchange(i, j);// vertauschen
			}

			if (!(pivotIdx < i))
				exchange(i, pivotIdx);// Pivotelement in die Mitte tauschen

			doQuicksortInterna(ilinks, i - 1);
			doQuicksortInterna(i + 1, irechts);
		}
	}

	public void exchange(int idx1, int idx2) {
		Element temp = _array[idx1];
		_array[idx1] = _array[idx2];
		_array[idx2] = temp;
		_counterOperations++;
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
		int random = ThreadLocalRandom.current().nextInt(ilinks, irechts + 1);
		return random;
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

	public int get_counterC() {
		return _counterCompares;
	}
	
	public int get_counterO() {
		return _counterOperations;
	}

	public void reset_counter() {
		this._counterOperations = 0;
		this._counterCompares = 0;
	}

}
