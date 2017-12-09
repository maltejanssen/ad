package impl;
import java.util.*;
public class Dijkstra {
	
	public static int dijkstra(Graph g, Node start, Node destination) {
		
		PriorityQueue<Node> p = new PriorityQueue<Node>(); //Verwaltung der länge des kürzesten Weges
		
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
			
			for (Edge e : g.getEdges(n)) {
				Node d = e.getSecondNode();
				int w = e.getWeight();
				if (d.distance > n.distance +w) {
					d.distance = n.distance +w;
					d.prev = n;
					p.add(d);
				}
			}
		}
		if (destination.distance == 0) {
			return -1;
		}
		return destination.distance;
	}
	
}
