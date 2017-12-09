package impl;
import java.util.*;
public class Dijkstra {
	
	public static int dijkstra(Graph g, Node start, Node destination) {
		
		PriorityQueue<Node> p = new PriorityQueue<Node>(); //Verwaltung der l�nge des k�rzesten Weges
		
		for (Node n : g.getNodes()) {
			n.distance = Integer.MAX_VALUE;
			n.seen = false;
			n.prev = null;
		}
		
		start.distance = 0;
		p.add(start);
		
		while (!p.isEmpty()) {
			Node n = p.poll(); //erster eintrag priority queue
			if (n.seen) continue;
			n.seen = true;
			
			for (Node d : g.getNeighbours(n)) {
				int w = g.getWeight(n, d);
				if (d.distance > n.distance +w) {
					d.distance = n.distance +w;
					d.prev = n;
					p.add(d);
				}
			}
			
//			for (Edge e : g.getEdges(n)) {
//				Node d = e.getSecondNode();
//				int w = e.getWeight();
//				if (d.distance > n.distance +w) {
//					d.distance = n.distance +w;
//					d.prev = n;
//					p.add(d);
//				}
//			}
		}
		if (destination.distance == Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Nodes are not conntected!");
		}
		return destination.distance;
	}
	
}