package test;

import impl.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testeModQuicksort {
	
	Element[] unsortedArray;

	@Before
	public void setUp() throws Exception {
		unsortedArray = performanceTest.fillArrayUnsorted(100);
	}

	@Test
	public void testWithLastElement() {
		modQuicksort.modifiedQuicksort(unsortedArray, pivotSucher.LAST);
		assertTrue(isSorted(unsortedArray));
		
	}

	@Test
	public void testWithRandom() {
		modQuicksort.modifiedQuicksort(unsortedArray, pivotSucher.RANDOM);
		assertTrue(isSorted(unsortedArray));
		
	}

	@Test
	public void testWithMedian() {
		modQuicksort.modifiedQuicksort(unsortedArray, pivotSucher.MEDIAN);
		assertTrue(isSorted(unsortedArray));
		
	}

	private boolean isSorted(Element[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].getKey() > array[i + 1].getKey()) {
				return false;
			}
		}
		return true;
	}
}
