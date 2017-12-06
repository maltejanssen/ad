package impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Adjazenzmatrix extends Graph {

	private HashMap<Node, Integer> nodes;
	private int[][] matrix;
	private int size = 0;

	public Adjazenzmatrix(Set<Node> nodes, Set<Edge> edges) {
		this.matrix = new int[nodes.size()][nodes.size()];
		this.nodes = new HashMap<Node, Integer>();
		
		for (Node n : nodes) {
			this.nodes.put(n, size);
			size++;
		}

		for (Edge e : edges) {
			setEdge(e);
		}
	}

	@Override
	public Pos add(Node node) {
		Pos pos = new Pos(node);
		if(!nodes.containsKey(node))
		{
			nodes.put(node, size);
			size++;
		}
		return pos;
	}

	@Override
	public boolean setEdge(Edge edge) {
		Node start = edge.getFirstNode();
		Node target = edge.getSecondNode();

		if (!nodes.containsKey(start)) {
			add(start);
		}

		if (!nodes.containsKey(target)) {
			add(target);
		}

		if (!doesEdgeExist(start, target)) {
			matrix[nodes.get(start)][nodes.get(target)] = edge.getWeight();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getWeight(Node start, Node target) {
		return matrix[nodes.get(start)][nodes.get(target)];
	}

	@Override
	public List<Node> getNeighbours(Node givenNode) {
		List<Node> neighbours = new LinkedList<Node>();
		return neighbours;
	}

	@Override
	public Set<Node> getNodes() {
		return nodes.keySet();
	}

	@Override
	public Iterator<Node> iterator() {
		return nodes.keySet().iterator();
	}

	private boolean doesEdgeExist(Node start, Node target) {
		if (matrix[nodes.get(start)][nodes.get(target)] != 0)
			return true;
		else
			return false;
	}
}
