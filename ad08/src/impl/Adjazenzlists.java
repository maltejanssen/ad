package impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Adjazenzlists<T> extends Graph<T>{
	
	Map<Vertice<T>,List<Vertice<T>>> nodes = new HashMap<Vertice<T>,List<Vertice<T>>>();
	Map<Vertice<T>,List<Edge<T>>> edges = new HashMap<Vertice<T>,List<Edge<T>>>();

	public Adjazenzlists(Set<Vertice<T>> vertices, Set<Edge<T>> edges) {
		super(vertices, edges);
	}

	@Override
	public int traversal(Vertice<T> start, Vertice<T> target) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
