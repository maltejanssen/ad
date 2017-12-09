package impl;


public class GraphBuilder {
	
	static Node startNode = null;
	static Node destinationNode = null;
	
	/**
	 * 
	 * @param size: min 2
	 * @return
	 */
	static Graph[] build(int size) {
		if (size < 2)
			throw new IllegalArgumentException("Too few nodes for a graph");
		Adjazenzlists aGraph = new Adjazenzlists();
		Adjazenzmatrix mGraph = new Adjazenzmatrix();
		
		Node node;
		Node[] nodes = new Node[size];
		for(int i=0;i<size;i++) {
			node = new Node();
			nodes[i] = node;
			mGraph.add(node);
			aGraph.add(node);
		}
		startNode = nodes[0];
		destinationNode = nodes[size-1];
		
		int linkingDegree = (int) (size * ((size-1) * Math.random()));
		if (linkingDegree == 0)
			linkingDegree = size;
		
		for(int i = 0; i < linkingDegree; i++) {
			Node node1 = nodes[(int) (size*Math.random())];
			Node node2;
			do {
			node2 = nodes[(int) (size*Math.random())];
			} while (node2 == node1);
			
			Edge e = new Edge(node1, node2, (int) (10*Math.random()+1));
			
			mGraph.setEdge(e);
			aGraph.setEdge(e);
		}
		Graph[] graphs = {aGraph, mGraph};
		return graphs;
	}
}
