package test;

import static org.junit.Assert.*;
import org.junit.*;

import impl.ArrayTree;
import impl.NodeTree;

class testTree {
	
	ArrayTree<Integer> arrayTree;
	NodeTree<Integer> nodeTree;
	
	@Before
	public void setUp() {
		arrayTree = new ArrayTree<Integer>();
		nodeTree = new NodeTree<Integer>();
		
		arrayTree.add(10);
		arrayTree.add(15);
		arrayTree.add(9);
		arrayTree.add(6);
		arrayTree.add(8);
		
		nodeTree.add(10);
		nodeTree.add(15);
		nodeTree.add(9);
		nodeTree.add(6);
		nodeTree.add(8);
	}
	
	@Test
	void testArrayTree() {
		arrayTree.printInOrder();
		assertTrue(true);
	}
	
	@Test
	void testNodeTree() {
		nodeTree.printInOrder();
		assertTrue(true);
	}

}
