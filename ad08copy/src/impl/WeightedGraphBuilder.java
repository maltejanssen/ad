package impl;

import java.util.Random;

enum AdjacencyImplementation {MATRIX, LIST};
public class WeightedGraphBuilder {
	static <T> IWeightedGraph<T> getEmptyNodes(int nodeCount, AdjacencyImplementation impl){
		IWeightedGraph<T> graph;
		if(impl == AdjacencyImplementation.MATRIX)
			graph = new WeightedGraphMatrix<T>(nodeCount);
		else
			graph = new WeightedGraphList<T>();
		
		@SuppressWarnings("unchecked")
		Node<T>[] nodes = (Node<T>[]) new Node[nodeCount];
		for(int i = 0; i < nodeCount; i++){
			nodes[i] = new Node<T>(null);
		}
		
		Random rnd = new Random();
		for(int i = 0; i < nodeCount; i++){
			//int noNodes = rnd.nextInt(nodeCount)/4;
			int noNodes = rnd.nextInt(2*(int)Math.round(Math.log10(nodeCount)));
			for(int j = 0; j < noNodes; j++)
				graph.insert(new WeightedEdge<T>(nodes[i],nodes[rnd.nextInt(nodeCount)],rnd.nextInt(100)));
		}
		
		for(int i = 0; i < nodeCount-1; i++){
			graph.insert(new WeightedEdge<T>(nodes[i], nodes[i+1], rnd.nextInt(100)));
		}
		
		return graph;
	}
	
	static public Node<?> dest;
	@SuppressWarnings({ "unchecked" })
	static <T> IWeightedGraph<T> getSpecialEmptyNodes(int nodeCount, AdjacencyImplementation impl){
		IWeightedGraph<T> graph;
		if(impl == AdjacencyImplementation.MATRIX)
			graph = new WeightedGraphMatrix<T>(nodeCount);
		else
			graph = new WeightedGraphList<T>();
		
		Node<T>[] nodes = (Node<T>[]) new Node[nodeCount];
		for(int i = 0; i < 6; i++){
			nodes[i] = new Node<T>(null);
		}
		
		dest = nodes[5];
		
		graph.insert(new WeightedEdge<T>(nodes[0], nodes[1], 1)); // A->B
		graph.insert(new WeightedEdge<T>(nodes[0], nodes[2], 6)); // A->C
		graph.insert(new WeightedEdge<T>(nodes[0], nodes[3], 7)); // A->D
		graph.insert(new WeightedEdge<T>(nodes[1], nodes[3], 1)); // B->D
		graph.insert(new WeightedEdge<T>(nodes[1], nodes[4], 5)); // B->E
		graph.insert(new WeightedEdge<T>(nodes[2], nodes[5], 3)); // C->F
		graph.insert(new WeightedEdge<T>(nodes[3], nodes[5], 1)); // D->F

		return graph;
	}
}
