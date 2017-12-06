package impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Adjazenzlists extends Graph {

	Map<Node,List<Node>> nodes = new HashMap<Node,List<Node>>();
	Map<Node,List<Edge>> edges = new HashMap<Node,List<Edge>>();
	
	public Adjazenzlists(Set<Node> vertices, Set<Edge> edges) {
		super(vertices, edges);
	}

	@Override
	public Pos add(Node node) {
		return null;
	}
	
	private boolean edgeExists(Node origin, Node destination) {
		if (origin.equals(destination)) {
			return true;
		}
		
		List<Edge> list = edges.get(origin);
		return false;
	}

	@Override
	public boolean setEdge(Edge edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getWeight(Node start, Node target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Node> getNeighbours(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Node> getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
