package impl;

import java.util.HashMap;
import java.util.Set;

public class Adjazenzmatrix extends Graph {

	int[][] matrix;
	HashMap<Vertice, Integer> verticesMap;

	public Adjazenzmatrix(Set<Vertice> vertices, Set<Edge> edges) {
		super(vertices, edges);
		this.verticesMap = new HashMap<Vertice, Integer>();

		int i = 0;
		for (Vertice v : vertices) {
			verticesMap.put(v, i);
			i++;
		}

		this.matrix = new int[vertices.size()][vertices.size()];

		computeMatrix();
	}

	private void computeMatrix() {
		for (Edge e : edges) {
			matrix[verticesMap.get(e.getFirstVertice())][verticesMap.get(e.getSecondVertice())] = e.getCost();
		}
	}

	@Override
	public int traversal(Vertice start, Vertice target) {
		// TODO Auto-generated method stub
		return 0;
	}

}
