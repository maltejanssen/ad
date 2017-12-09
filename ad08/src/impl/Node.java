package impl;

public class Node implements Comparable<Node> {
	
	public final int ID;
	
	private static int nextID = 0;
	
	public int distance;
	public boolean seen;
	public Node prev;
	
	public Node() {
		this.ID = nextID;
		nextID++;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		
		if(o == null) 
			return false;
		
		if(o instanceof Node) {
			Node v = (Node) o;
			return this.ID == v.ID;
		} else {
			return false;
		}
		
	}

	@Override
	public int hashCode(){
		return ID;
	}

	@Override
	public int compareTo(Node other) {
		return distance - other.distance;
	}
}
