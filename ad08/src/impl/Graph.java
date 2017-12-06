package impl;
import java.util.Set;

public abstract class Graph {
	
	protected Set<Vertice> vertices = null;
	protected Set<Edge> edges = null;
	
	/**
	 * creates a grph with given Vertices and Edges
	 * @param vertices
	 * @param edges
	 */
	public Graph(Set<Vertice> vertices, Set<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	/**
	 * traversals the graph from given vertice to the target and calculates the cost
	 * @return the minimal cost
	 */
	public abstract int traversal(Vertice start, Vertice target);
	
}
