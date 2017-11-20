package impl;

import impl.pivotSucher;



public class performanceTest {
	
	public static void main(String[] args) {
		Aufwand();

	}

	public static void Aufwand() {
		System.out.println("\n UnsortedArray Pivot = Median");
		for (int i = 10; i <= 1000000; i *= 10) {
			for (int j = 0;j<10;j++) {
				Element[] array1 = fillArrayUnsorted700to800(i);
				Element[] array2 = new Element[i];
				System.arraycopy(array1, 0, array2, 0, array1.length);
				Quicksort.quicksort(array1, pivotSucher.MEDIAN);
				modQuicksort.modifiedQuicksort(array2, pivotSucher.MEDIAN);
//				if (i == 1000) {
//					for(int t = 0; t < 1000; t++)
//					{
//						System.out.print(array2[t].getKey()+", ");
//					}
//				}
			}


			System.out.println("N = "+i);
			System.out.println("counterCompares: " + Quicksort._counterCompares /10);
			System.out.println("counterComparesMOD: " + modQuicksort._counterCompares /10);
			System.out.println("counterSwitches: " + Quicksort._counterSwitches /10);
			System.out.println("counterSwitchesMOD: " + modQuicksort._counterSwitches /10);
			System.out.println("Time: "+Quicksort._time /10);
			System.out.println("TimeMOD: "+modQuicksort._time /10);
			
			Quicksort.reset();
			modQuicksort.reset();
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
	
	public static Element[] fillArrayUnsorted700to800(int size) {
		Element[] array = new Element[size];
		for (int i = 0; i < size; i++) {
			array[i] = new Element((int) (7*size*100 + (Math.random() * size*100)));
		}
		return array;
	}
}
