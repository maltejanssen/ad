package impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Adjazenzmatrix extends Graph {

	int[][] matrix;

	public Adjazenzmatrix(Set<Node> vertices, Set<Edge> edges) {
		super(vertices, edges);

		this.matrix = new int[vertices.size()][vertices.size()];
//
//		computeMatrix();
	}

//	private void computeMatrix() {
//		for (Edge e : edges) {
//			matrix[e.getFirstVertice().ID][e.getSecondVertice().ID] = e.getCost();
//		}
//	}

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
