package impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Adjazenzlists extends Graph {

	// Map<Node<T>,List<Node<T>>> nodes = new HashMap<Node<T>,List<Node<T>>>();
	// Map<Node<T>,List<Edge<T>>> edges = new HashMap<Node<T>,List<Edge<T>>>();
	//
	public Adjazenzlists(Set<Node> vertices, Set<Edge> edges) {
		super(vertices, edges);
	}

	@Override
	public Pos add(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setEdge(Edge edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getWeight(Node start, Node target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Node> getNeighbours(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Node> getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
