package impl;

public class Node {
	
	public final int ID;
	
	private static int nextID = 0;
	
	public Node() {
		this.ID = nextID;
		nextID++;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		
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
}
