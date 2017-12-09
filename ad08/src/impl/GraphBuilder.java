package impl;
import java.util.Random;

public class GraphBuilder {
	
	static Graph[] build(int size) {
		Adjazenzlists aGraph = new Adjazenzlists();
		Adjazenzmatrix mGraph = new Adjazenzmatrix();
		
		Node node;
		for(int i=0;i<size;i++) {
			node = new Node();
			mGraph.add(node);
			aGraph.add(node);
		}

	}
}
