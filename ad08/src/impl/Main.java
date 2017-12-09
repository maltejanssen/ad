package impl;


import java.util.HashSet;
import java.util.Set;

public class Main {

	static Graph g;
	
	public Main() {
		
	}

	public static void main(String[] args) {
		Set<Node> v = new HashSet<Node>();
		Node v1 = new Node();
		Node v2 = new Node();
		Node v3 = new Node();
		Node v4 = new Node();
		Node v5 = new Node();
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		v.add(v5);
		
		Set<Edge> e = new HashSet<Edge>();
		e.add(new Edge(v1,v3, 2));
		e.add(new Edge(v4,v3, 3));
		e.add(new Edge(v1,v4, 4));
		e.add(new Edge(v1,v2, 1));
		e.add(new Edge(v5,v2, 7));
		g = new Adjazenzmatrix(v, e);
		int result = Dijkstra.dijkstra(g, v1, v5);
		System.out.println(result);
		
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
