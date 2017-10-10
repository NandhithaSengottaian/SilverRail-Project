package com.shortestpath;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestCase {

	private List<Vertex> nodes;
	private List<Edge> edges;

	@Test
	public void testExcute() {
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Path_" + i, "Path_" + i);
			nodes.add(location);
		}
		
		/**
		 * Setup the test data - It's all your wish
		 * Format should be  node name, starting point, end point, distance between two points.
		 */
		addLane("Edge_0", 0, 1, 85);
		addLane("Edge_1", 0, 2, 217);
		addLane("Edge_2", 0, 4, 173);
		addLane("Edge_3", 2, 6, 186);
		addLane("Edge_4", 2, 7, 103);
		addLane("Edge_5", 3, 7, 183);
		addLane("Edge_6", 5, 8, 250);
		addLane("Edge_7", 8, 9, 84);
		addLane("Edge_8", 7, 9, 167);
		addLane("Edge_9", 4, 9, 502);
		addLane("Edge_10", 9, 10, 40);
		addLane("Edge_11", 1, 10, 600);

		/** Example :: If u need to get shortest path between x and y nodes.**/
		Graph graph = new Graph(nodes, edges);
		ShortestPath spath = new ShortestPath(graph);
		spath.execute(nodes.get(7));   // Starting point - Like 0,4,5 etc
		LinkedList<Vertex> path = spath.getPath(nodes.get(10));  // End point - 8,9,10 etc

		assertNotNull(path);
		assertTrue(path.size() > 0);

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}
}