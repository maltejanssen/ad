package test;

import impl.*;
import impl.Quicksort.pivotSucher;

import static org.junit.Assert.*;

import org.junit.Test;

public class testeQuicksort {

	Element[] unsortedArray4 = {new Element(2), new Element(5), new Element(1), new Element(3)};
	Element[] preSortedArray4 = {new Element(1), new Element(2), new Element(3), new Element(5)};
	Element[] unsortedArray6 = {new Element(13), new Element(4), new Element(7), new Element(2), new Element(1), new Element(20)};
	Element[] preSortedArray6 = {new Element(1), new Element(2), new Element(4), new Element(7), new Element(13), new Element(20)};

	Quicksort QS;
	@Test
	public void testWithLastElement() {
		QS = new Quicksort(unsortedArray4, pivotSucher.LAST_ELEMENT);
		Element[] sortedArray4 = QS.doQuicksort();
		assertArrayEquals(preSortedArray4, sortedArray4);
		
//		QS = new Quicksort(unsortedArray6, pivotSucher.LAST_ELEMENT);
//		Element[] sortedArray6 = QS.doQuicksort();
//		assertArrayEquals(preSortedArray6, sortedArray6);
		
	}
	
	@Test
	public void testWithRandom() {
		QS = new Quicksort(unsortedArray4, pivotSucher.RANDOM);
		Element[] sortedArray4 = QS.doQuicksort();
		assertArrayEquals(preSortedArray4, sortedArray4);
		
		QS = new Quicksort(unsortedArray6, pivotSucher.RANDOM);
		Element[] sortedArray6 = QS.doQuicksort();
		assertArrayEquals(preSortedArray6, sortedArray6);
	}
	
	@Test
	public void testWithMedian() {
		QS = new Quicksort(unsortedArray4, pivotSucher.MEDIAN);
		Element[] sortedArray4 = QS.doQuicksort();
		assertArrayEquals(preSortedArray4, sortedArray4);
		
//		QS = new Quicksort(unsortedArray6, pivotSucher.MEDIAN);
//		Element[] sortedArray6 = QS.doQuicksort();
//		assertArrayEquals(preSortedArray6, sortedArray6);
	}

}
