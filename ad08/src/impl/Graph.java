package impl;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class Graph implements Iterable<Node> {
	
	Set<Node> nodes;
	
	public Graph(Set<Node> nodes, Set<Edge> edges) {
		for (Node n : nodes) {
			if(nodes.add(n))
			{
				this.add(n);
			}
		}
		
		for (Edge e : edges) {
			this.setEdge(e);
		}
		
		
	}
	
	public abstract Pos add(Node node);
	
	public abstract boolean setEdge(Edge edge);

	public abstract int getWeight(Node start, Node target);
	
	public abstract List<Node> getNeighbours(Node node);
	
	public abstract Set<Node> getNodes();
	
	@Override
	public Iterator<Node> iterator() {
		return nodes.iterator();
	}
	
}
