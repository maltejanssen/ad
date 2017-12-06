package impl;

public class Edge {
	
	private Node firstVertice;
	private Node secondVertice;
	private int weight;

	public Edge(Node firstVertice, Node secondVertice, int weight) {
		this.firstVertice = firstVertice;
		this.secondVertice = secondVertice;
		
		if(weight <= 0)
			throw new IllegalArgumentException("the weight must be a positive value");
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
