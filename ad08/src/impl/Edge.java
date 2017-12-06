package impl;

public class Edge {
	
	private Node firstVertice;
	private Node secondVertice;
	private int weight;

	public Edge(Node firstVertice, Node secondVertice, int weight) {
		this.firstVertice = firstVertice;
		this.secondVertice = secondVertice;
		this.weight = weight;
	}
	
	public Node getFirstNode() {
		return firstVertice;
	}
	
	public Node getSecondNode() {
		return secondVertice;
	}
	
	public int getWeight() {
		return weight;
	}
}
