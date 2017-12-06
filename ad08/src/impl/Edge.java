package impl;

public class Edge<T> {
	
	private Vertice<T> firstVertice;
	private Vertice<T> secondVertice;
	private int weight;

	public Edge(Vertice<T> firstVertice, Vertice<T> secondVertice, int cost) {
		this.firstVertice = firstVertice;
		this.secondVertice = secondVertice;
		this.weight = cost;
	}
	
	public Vertice<T> getFirstVertice() {
		return firstVertice;
	}
	
	public Vertice<T> getSecondVertice() {
		return secondVertice;
	}
	
	public int getWeight() {
		return weight;
	}
}
