import java.util.*;
/*
 * Name: Andrew Boothe
 * Class: CSE-374
 * Goal: Finding cheapest flight cost
 * Date: 10/3/2022
 *  */
class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		// n = vertices number
		// flights = 2D array of edges
		// src = identifier of vertex
		// dst = identifier of final vertex
		// k = num of stops
		/***PROPERTIES***/
		// returns the best possible key value pairs in terms of cost
		HashMap<Integer, Integer> best = new HashMap();

		// Deploy adjacency matrix
		int[][] adjList = new int[n][n];

		// priority queue will compare the sets of costs and decide which paths are convenient and which aren't
		Comparator<int[]> compareTo = (cost1, cost2) -> cost1[0] - cost2[0];
		
		PriorityQueue<int[]> vertices = new PriorityQueue<int[]>(compareTo);
		/***SOURCE***/
		// Add in the root node (cost, destination node, source node)
		int[] source = {0, 0, src};
		vertices.add(source);

		for (int i=0; i<flights.length; i++) {
			adjList[flights[i][0]][flights[i][1]] = flights[i][2];
		}

		// gradually empties the priority queue
		while (!vertices.isEmpty()) {
			// pull top-most vertex and remove it
			int[] vertex = vertices.poll();
			// initialize each elements of PQ node into cost tester 
			int cost = vertex[0], towards = vertex[1], place = vertex[2];

			// must take at least K+1 stops
			if (towards > K+1) {
				continue;
				// or there are costs to compare
			} else if (cost > best.getOrDefault(towards*100+place, 1000000)) {
				continue;
			}

			// finishes program once the best cost destination is found
			if (place == dst)
				return cost;

			// check the adjacency list for opposing costs and update the PQ and best HashMap
			for (int i=0; i<n; i++) {
				if (adjList[place][i] > 0) {
					int nextCost = cost + adjList[place][i];
					if (nextCost < best.getOrDefault((towards+1)*100+i, 1000000)) {
						int[] nextNode = {nextCost, towards+1, i};
						vertices.add(nextNode);
						best.put((towards+1)*100+i, nextCost);
					}
				}

			}
		}
		// no viable path found?
		return -1;
	}

	// Deprecated Code (may be useful later on)
	//	int[][] flightsAdj = new int[n][n];
	//			for (int i=0; i<n; i++) {
	//				flightsAdj[i][i] = Integer.MAX_VALUE;
	//				for (int j=0; j<n; j++) {
	//					if (i == flights[j][0]) {
	//						flightsAdj[i][flights[j][1]] = flights[j][2];
	//					} else if (i == flights[j][1]) {
	//						flightsAdj[i][flights[j][0]] = flights[j][2];
	//					}
	//				}
	//			}
	//					for (int j = 0; j < n; j++) {
	//						for (int k = 0; k < n; k++) {
	//							System.out.println(flightsAdj[j][k]);
	//						}
	//					}


	// For testing
	//	public static void main(String[] args) {
	//		int vertices = 3;
	//		int[][] flights =  {{0,1,100}, {1,2,100}, {0,2,500}};
	//		int start = 0;
	//		int end = 2;
	//		int cost = 1;
	//
	//		// should output 200
	//		System.out.println(findCheapestPrice(vertices, flights, start, end, cost));
	//	}
}
