package impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Adjazenzmatrix extends Graph {

	Set<Node> nodes;
	int[][] matrix;

	public Adjazenzmatrix(Set<Node> nodes, Set<Edge> edges) {
		this.matrix = new int[nodes.size()][nodes.size()];
		this.nodes = nodes;

		for (Edge e : edges) {
			setEdge(e);
		}
	}

	@Override
	public Pos add(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setEdge(Edge edge) {
		if (matrix[edge.getFirstNode().ID][edge.getSecondNode().ID] == 0) {
			matrix[edge.getFirstNode().ID][edge.getSecondNode().ID] = edge.getWeight();
			return true;
		}
		return false;
	}

	@Override
	public int getWeight(Node start, Node target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Node> getNeighbours(Node givenNode) {
		List<Node> neighbours = new LinkedList<Node>();
		for (Node n: nodes)
		{
			if(doesEdgeExist(givenNode, n)) {
				neighbours.add(n);
			}
		}
		return neighbours;
	}

	@Override
	public Set<Node> getNodes() {
		return nodes;
	}

	@Override
	public Iterator<Node> iterator() {
		return nodes.iterator();
	}

	private boolean doesEdgeExist(Node start, Node target) {
		if (matrix[start.ID][target.ID] != 0)
			return true;
		else
			return false;
	}
}
