package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Adjazenzlists extends Graph {

	Map<Node,List<Node>> nodes = new HashMap<Node,List<Node>>();
	Map<Node,List<Edge>> edges = new HashMap<Node,List<Edge>>();
	
	public Adjazenzlists(Set<Node> nodes, Set<Edge> edges) {
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

	@Override
	public Pos add(Node node) {
		if (!nodes.containsKey(node)) {
			List<Node> nodeList = new ArrayList<Node>();
			List<Edge> edgeList = new ArrayList<Edge>();
			nodes.put(node, nodeList);
			edges.put(node, edgeList);
			
		}
		return null;
		
	}
	
	private boolean doesEdgeExists(Node origin, Node destination) {
		if (origin.equals(destination)) {
			return true;
		}
		List<Edge> list = edges.get(origin);
		if(list!=null) {
			for (Edge e : list) {
				if (e.getSecondNode() == destination) {
					return true;
				}
			}
		}
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

	@Override
	public Iterator<Node> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
