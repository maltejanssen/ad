package impl;

import java.util.*;


public class Adjazenzlists extends Graph {

	Map<Node,List<Node>> nodes; 
	Map<Node,List<Edge>> edges; 
	
	public Adjazenzlists(Set<Node> nodes, Set<Edge> edges) {
		this.nodes = new HashMap<Node,List<Node>>();
		this.edges = new HashMap<Node,List<Edge>>();		
		
		for (Node n : nodes) {
			this.add(n);
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
			return new Pos(node);
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
		//if node in nodes _> node is also in edges
		if (!nodes.containsKey(edge.getFirstNode())) {
			add(edge.getFirstNode());
		}
		if (!nodes.containsKey(edge.getSecondNode())) {
			add(edge.getSecondNode());
		}
		if(!doesEdgeExists(edge.getFirstNode(), edge.getSecondNode())) {
			nodes.get(edge.getFirstNode()).add(edge.getSecondNode());
			edges.get(edge.getFirstNode()).add(edge);
			return true;
		}
		return false;
	}

	@Override
	public int getWeight(Node start, Node target) {
		if(start.equals(target)) {
			return 0;
		}
		List<Edge> list = edges.get(start);
		for(Edge e : list) {
			if (e.getSecondNode() == target){
				return e.getWeight();
			}
		}
		return 0;
	}

	@Override
	public List<Node> getNeighbours(Node node) {
		return nodes.get(node);
	}

	@Override
	public Set<Node> getNodes() {
		return nodes.keySet();
	}
	
	@Override
	public List<Edge> getEdges(Node n) {
		return edges.get(n);
	}

	@Override
	public Iterator<Node> iterator() {
		Set<Node> nodeSet = getNodes();
		return nodeSet.iterator();
	}


}
