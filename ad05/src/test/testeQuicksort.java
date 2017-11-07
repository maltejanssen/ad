package test;

import impl.*;
import pivot.pivotLastElement;
import pivot.pivotMedian;
import pivot.pivotRandom;

import static org.junit.Assert.*;

import org.junit.Test;

public class testeQuicksort {

	Element[] unsortedArray4 = {new Element(2), new Element(5), new Element(1), new Element(3)};
	Element[] preSortedArray4 = {new Element(1), new Element(2), new Element(3), new Element(5)};
	Element[] unsortedArray6 = {new Element(13), new Element(4), new Element(7), new Element(2), new Element(1), new Element(20)};
	Element[] preSortedArray6 = {new Element(1), new Element(2), new Element(4), new Element(7), new Element(13), new Element(20)};

	Quicksort QS;
	@Test
	public void testWithMedian() {
		QS = new Quicksort();
		
		Element[] sortedArray4 = QS.quicksort(unsortedArray4, new pivotMedian());
		assertArrayEquals(preSortedArray4, sortedArray4);
		
		Element[] sortedArray6 = QS.quicksort(unsortedArray6, new pivotMedian());
		assertArrayEquals(preSortedArray6, sortedArray6);
	}
	
//	@Test
//	public void testWithRandom() {
//		QS = new Quicksort();
//		
//		Element[] sortedArray4 = QS.quicksort(unsortedArray4, new pivotRandom());
//		assertArrayEquals(preSortedArray4, sortedArray4);
//		
//		Element[] sortedArray6 = QS.quicksort(unsortedArray6, new pivotRandom());
//		assertArrayEquals(preSortedArray6, sortedArray6);
//	}
//	
//	@Test
//	public void testWithLastElement() {
//		QS = new Quicksort();
//		
//		Element[] sortedArray4 = QS.quicksort(unsortedArray4, new pivotLastElement());
//		assertArrayEquals(preSortedArray4, sortedArray4);
//		
//		Element[] sortedArray6 = QS.quicksort(unsortedArray6, new pivotLastElement());
//		assertArrayEquals(preSortedArray6, sortedArray6);
//	}

}
