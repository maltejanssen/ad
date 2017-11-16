package impl;

import impl.pivotSucher;



public class performanceTest {

	public static void main(String[] args) {
		Aufwand();

	}

	public static void Aufwand() {
		System.out.println("\n SortedArray Pivot = Last");
		for (int i = 1; i <= 10000; i *= 10) {
			Element[] array = fillArraySorted(i);
			Quicksort.quicksort(array, pivotSucher.LAST_ELEMENT);
			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches);
			System.out.println("Time: "+Quicksort._time);
			Quicksort.reset();
		}

		System.out.println("\n UnsortedArray Pivot = Last");
		for (int i = 1; i <= 10000; i *= 10) {
			Element[] array = fillArrayUnsorted(i);
			Quicksort.quicksort(array, pivotSucher.LAST_ELEMENT);
			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches);
			System.out.println("Time: "+Quicksort._time);
			Quicksort.reset();
		}
		
		System.out.println("\n SortedArray Pivot = Median");
		for (int i = 1; i <= 10000; i *= 10) {
			Element[] array = fillArraySorted(i);
			Element[] array2 = new Element[i];
			System.arraycopy(array, 0, array2, 0, array.length);
			Quicksort.quicksort(array, pivotSucher.MEDIAN);
			modQuicksort.modifiedQuicksort(array2, pivotSucher.MEDIAN);
			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares);
			System.out.println("counterComparesMMM: " + modQuicksort._counterCompares);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches);
			System.out.println("counterSwitchesMMM: " + modQuicksort._counterSwitches);
			System.out.println("Time: "+Quicksort._time);
			System.out.println("TimeMMM: "+modQuicksort._time);
			Quicksort.reset();
			modQuicksort.reset();
		}

		System.out.println("\n UnsortedArray Pivot = Median");
		for (int i = 1; i <= 10000; i *= 10) {
			Element[] array = fillArrayUnsorted(i);
			Element[] array2 = new Element[i];
			System.arraycopy(array, 0, array2, 0, array.length);
			Quicksort.quicksort(array, pivotSucher.MEDIAN);
			modQuicksort.modifiedQuicksort(array2, pivotSucher.MEDIAN);
			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares);
			System.out.println("counterComparesMMM: " + modQuicksort._counterCompares);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches);
			System.out.println("counterSwitchesMMM: " + modQuicksort._counterSwitches);
			System.out.println("Time: "+Quicksort._time);
			System.out.println("TimeMMM: "+modQuicksort._time);
			if (i == 1000) {
				for(int j = 0; j < 1000; j++)
				{
					System.out.print(array2[j].getKey()+", ");
				}
			}
			Quicksort.reset();
			modQuicksort.reset();
		}
		
		System.out.println("\n SortedArray Pivot = Random");
		for (int i = 1; i <= 10000; i *= 10) {
			Element[] array = fillArraySorted(i);
			Quicksort.quicksort(array, pivotSucher.RANDOM);
			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches);
			System.out.println("Time: "+Quicksort._time);
			Quicksort.reset();
		}

		System.out.println("\n UnsortedArray Pivot = Random");
		for (int i = 1; i <= 10000; i *= 10) {
			Element[] array = fillArrayUnsorted(i);
			Quicksort.quicksort(array, pivotSucher.RANDOM);
			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches);
			System.out.println("Time: "+Quicksort._time);
			Quicksort.reset();
		}
	}
	
	public static Element[] fillArraySorted(int size) {
		Element[] array = new Element[size];
		for (int i = 0; i <= size - 1; i++) {
			array[i] = new Element((int) (i));
		}
		return array;
	}

	public static Element[] fillArrayUnsorted(int size) {
		Element[] array = new Element[size];
		for (int i = 0; i <= size - 1; i++) {
			array[i] = new Element((int) (Math.random() * size));
		}
		return array;
	}
}
