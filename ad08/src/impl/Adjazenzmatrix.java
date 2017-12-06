package impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Adjazenzmatrix extends Graph {

	int[][] matrix;

	public Adjazenzmatrix(Set<Vertice> vertices, Set<Edge> edges) {
		super(vertices, edges);

		this.matrix = new int[vertices.size()][vertices.size()];

		computeMatrix();
	}

	private void computeMatrix() {
		for (Edge e : edges) {
			matrix[e.getFirstVertice().ID][e.getSecondVertice().ID] = e.getCost();
		}
	}

	@Override
	public int traversal(Vertice start, Vertice target) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
