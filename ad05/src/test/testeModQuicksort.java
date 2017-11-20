package test;

import impl.*;
import impl.pivotSucher;


import static org.junit.Assert.*;

import org.junit.Test;

public class testeModQuicksort {

	Element[] unsortedArray4 = {new Element(2), new Element(5), new Element(1), new Element(3)};
	Element[] preSortedArray4 = {new Element(1), new Element(2), new Element(3), new Element(5)};
	Element[] unsortedArray6 = {new Element(13), new Element(4), new Element(7), new Element(2), new Element(1), new Element(20)};
	Element[] preSortedArray6 = {new Element(1), new Element(2), new Element(4), new Element(7), new Element(13), new Element(20)};

	@Test
	public void testWithLastElement() {
		modQuicksort.modifiedQuicksort(unsortedArray4, pivotSucher.LAST_ELEMENT);
		assertArrayEquals(preSortedArray4, unsortedArray4);
		
		modQuicksort.modifiedQuicksort(unsortedArray6, pivotSucher.LAST_ELEMENT);
		assertArrayEquals(preSortedArray6, unsortedArray6);
		
	}
	
	@Test
	public void testWithRandom() {
		modQuicksort.modifiedQuicksort(unsortedArray4, pivotSucher.RANDOM);
		assertArrayEquals(preSortedArray4, unsortedArray4);
		
		Quicksort.quicksort(unsortedArray6, pivotSucher.RANDOM);
		assertArrayEquals(preSortedArray6, unsortedArray6);
	}
	
	@Test
	public void testWithMedian() {
		modQuicksort.modifiedQuicksort(unsortedArray4, pivotSucher.MEDIAN);
		assertArrayEquals(preSortedArray4, unsortedArray4);
		
		modQuicksort.modifiedQuicksort(unsortedArray6, pivotSucher.MEDIAN);
		assertArrayEquals(preSortedArray6, unsortedArray6);

	}

}
