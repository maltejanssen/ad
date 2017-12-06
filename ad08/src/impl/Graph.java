package impl;
import java.util.List;
import java.util.Set;

public abstract class Graph implements Iterable<Node> {
	
	public abstract Pos add(Node node);
	
	public abstract boolean setEdge(Edge edge);

	public abstract int getWeight(Node start, Node target);
	
	public abstract List<Node> getNeighbours(Node node);
	
	public abstract Set<Node> getNodes();
	

}
