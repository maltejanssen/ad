package impl;

public class Edge {
	
	private Vertice firstVertice;
	private Vertice secondVertice;
	private int cost;

	public Edge(Vertice firstVertice, Vertice secondVertice, int cost) {
		this.firstVertice = firstVertice;
		this.secondVertice = secondVertice;
		this.cost = cost;
	}
	
	public Vertice getFirstVertice() {
		return firstVertice;
	}
	
	public Vertice getSecondVertice() {
		return secondVertice;
	}
	
	public int getCost() {
		return cost;
	}
}
