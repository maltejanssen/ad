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
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		
		Set<Edge> e = new HashSet<Edge>();
		e.add(new Edge(v1,v2, 2));
		e.add(new Edge(v2,v3, 4));
		e.add(new Edge(v3,v1, 2));
		g = new Adjazenzlists(v, e);
		
		
		for (Node f : g)
		{
			System.out.println(f.ID);
		}

	}

}
