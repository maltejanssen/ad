package impl;

import java.util.HashSet;
import java.util.Set;

public class Main {

	static Graph g;
	
	public Main() {
		
	}

	public static void main(String[] args) {
		Set<Vertice> v = new HashSet<Vertice>();
		Vertice v1 = new Vertice(0);
		Vertice v2 = new Vertice(1);
		Vertice v3 = new Vertice(2);
		Vertice v4 = new Vertice(3);
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		
		Set<Edge> e = new HashSet<Edge>();
		e.add(new Edge(v1,v2, 2));
		e.add(new Edge(v2,v3, 4));
		e.add(new Edge(v3,v1, 2));
		g = new Adjazenzmatrix(v, e);
		
		
		for (Vertice f : g)
		{
			System.out.println(f.ID);
		}

	}

}
