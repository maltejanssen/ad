package impl;


import java.util.HashSet;
import java.util.Set;

public class Main {

	static Graph g;
	
	public Main() {
		
	}

	public static void main(String[] args) {

		Graph[] graphs = GraphBuilder.buildGraphs(100);
		int resultList = Dijkstra.dijkstra(graphs[0], GraphBuilder.startNode, GraphBuilder.destinationNode);
		int resultMatrix = Dijkstra.dijkstra(graphs[1], GraphBuilder.startNode, GraphBuilder.destinationNode);

		System.out.println("Ad.List: "+resultList+"\nAd.Matrix: "+resultMatrix);
		
//		for (Node f : g)
//		{
//			System.out.println(f.ID);
//		}
//		List<Node> neighbours = g.getNeighbours(v2);
//		
//		for (Node f : neighbours)
//			System.out.println(f.ID);

	}

}
