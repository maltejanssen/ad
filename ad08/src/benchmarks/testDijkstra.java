package benchmarks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

import impl.Dijkstra;
import impl.Graph;
import impl.GraphBuilder;

public class testDijkstra extends AbstractBenchmark {

	final int SIZE = 10000;
	
	Graph listsGraph;
	Graph matrixGraph;

	
	@Before
	public void setUp() throws Exception {
		Graph[] graphs = GraphBuilder.buildGraphs(SIZE);
		listsGraph = graphs[0];
		matrixGraph = graphs[1];
	}

	@BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 10)
	@Test
	public void benchDijkstraWithListsGraph() throws Exception{
		int result = Dijkstra.dijkstra(listsGraph, GraphBuilder.startNode, GraphBuilder.destinationNode);
		assertEquals(SIZE-1, result);
	}
	
	@BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 10)
	@Test
	public void benchDijkstraWithMatrixGraph() throws Exception{
		int result = Dijkstra.dijkstra(matrixGraph, GraphBuilder.startNode, GraphBuilder.destinationNode);
		assertEquals(SIZE-1, result);
	}

}
