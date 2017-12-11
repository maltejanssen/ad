package impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphBuilder {
	
	public static Node startNode = null;
	public static Node destinationNode = null;

	
	/**
	 * 
	 * @param size: min 2
	 * @return array of graphs: #0 ListsGraph, #1 MatrixGraphs
	 */
	public static Graph[] buildGraphs(int size) {
		if (size < 2)
			throw new IllegalArgumentException("Too few nodes for a graph");
		
		Node[] nodes = createNodeArray(size);
		Set<Node> nodesSet = new HashSet<Node>(Arrays.asList(nodes));
		Set<Edge> edgesSet = createEdgesSet(size, nodes);
		Graph aGraph = new Adjazenzlists(nodesSet, edgesSet);
		Graph mGraph = new Adjazenzmatrix(nodesSet, edgesSet);
		Graph[] graphs = {aGraph, mGraph};
		return graphs;
	}
	
	private static Set<Edge> createEdgesSet(int size, Node[] nodes) {
		Set<Edge> edgesSet = new HashSet<Edge>();
		for(int i = 0; i < size-1; i++) {
			Node node1 = nodes[i];
			Node node2 = nodes[i+1];
			Edge e = new Edge(node1, node2, 1);
			edgesSet.add(e);
		}
		return edgesSet;
	}

	private static Node[] createNodeArray(int size) {
		Node node;
		Node[] nodes = new Node[size];
		for(int i=0;i<size;i++) {
			node = new Node();
			nodes[i] = node;
		}
		startNode = nodes[0];
		destinationNode = nodes[size-1];
		return nodes;
	}
}
