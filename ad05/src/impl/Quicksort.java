package impl;

import java.util.concurrent.ThreadLocalRandom;
import impl.pivotSucher;

public class Quicksort {
	
	public static int _counterSwitches;
	public static int _counterCompares;
	public static long _time;
	
	public static void quicksort(Element[] array, pivotSucher p) {
		long timeStamp = System.nanoTime();
		doQuicksort(array, 0, array.length - 1, p);
		_time = System.nanoTime() - timeStamp;
	}

	private static void doQuicksort(Element[] array, int idxLeft, int idxRight, pivotSucher p) {
		if (idxLeft >= idxRight) {
			return;
		}
		if (idxLeft < 0) {
			return;
		}
		if (idxRight > array.length - 1) {
			return;
		}

		int pivotIdx = partition(array, idxLeft, idxRight, p);
		
		doQuicksort(array, idxLeft, pivotIdx-1,p);
		doQuicksort(array, pivotIdx+1, idxRight, p);
	}

	public static int partition(Element[] array, int idxLeft, int idxRight, pivotSucher p) {

		int pivotIdx = getPivotElement(array, idxLeft, idxRight,p);
		int pivot = array[pivotIdx].getKey();

		int l, r;
		l = idxLeft;
		r = idxRight;

		exchange(array, pivotIdx, idxRight);
		pivotIdx = idxRight;
		r--;
		
		while(l<=r) {
			if(array[l].getKey() <pivot) {
				_counterCompares++;
				l++;	
			}
			else {
				_counterCompares++;
				exchange(array,l,r);
				r--;
			}
		}
		
		
		exchange(array, l, pivotIdx);
		pivotIdx = l;
		return pivotIdx;
	}

	public static void exchange(Element[] array, int idx1, int idx2) {
		Element temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
		_counterSwitches++;
	}

	private static int getPivotElement(Element[] array, int ilinks, int irechts,pivotSucher p) {

		switch (p) {

		case LAST:
			return getPivotLastElement(ilinks, irechts);
		case MEDIAN:
			return getPivotMedian(array, ilinks, irechts);
		case RANDOM:
			return getPivotRandom(ilinks, irechts);
		default:
			return ilinks;
		}
	}

	private static int getPivotLastElement(int ilinks, int irechts) {
		return irechts;
	}

	private static int getPivotRandom(int ilinks, int irechts) {
		int random = ThreadLocalRandom.current().nextInt(ilinks, irechts + 1);
		return random;
	}

	private static int getPivotMedian(Element[] array, int ilinks, int irechts) {
		int a = array[ilinks].getKey();
		int b = array[ilinks + (irechts - ilinks) / 2].getKey();
		int c = array[irechts].getKey();
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

	public static void reset() {
		_counterSwitches = 0;
		_counterCompares = 0;
		_time = 0;
	}
}
