package impl;
import java.util.Iterator;
import java.util.Set;

public abstract class Graph<T> implements Iterable<Vertice<T>> {
	
	protected Set<Vertice<T>> vertices = null;
	protected Set<Edge<T>> edges = null;
	
	/**
	 * creates a grph with given Vertices and Edges
	 * @param vertices
	 * @param edges
	 */
	public Graph(Set<Vertice<T>> vertices, Set<Edge<T>> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	/**
	 * traversals the graph from given vertice to the target and calculates the cost
	 * @return the minimal cost
	 */
	public abstract int traversal(Vertice<T> start, Vertice<T> target);
	
	@Override
	public Iterator<Vertice<T>> iterator() {
		return vertices.iterator();
	}
	
}
