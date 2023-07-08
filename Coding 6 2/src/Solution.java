import java.util.*;

class Solution {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		// Went through many rough drafts of Prim's Algorithm and could not get it,
		// here is a PriorityQueue based implementation
		
		
		// initialize Vertex class with properties in Map (source, cost to get to it, is it destination or not?
		class Vertex {
		    int source;
		    int cost;
		    int dest;   
		    
		    // Constructor for initializing new vertices
		    public Vertex(int city, int cost, int dest){
		        this.source = city;
		        this.cost = cost;
		        this.dest = dest;
		    }
		}
        
		// Each entry in the hash has its point, and a list of its costs
        HashMap<Integer, List<int[]>> flightPath = new HashMap<>();
        
        // 
        for(int[] flight: flights){
            if(!flightPath.containsKey(flight[0])){
                flightPath.put(flight[0], new ArrayList<int[]>());
            }
            
            flightPath.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>((a,b) -> (a.cost - b.cost));
        
        q.add(new Vertex(src, 0, -1));
        
        while(!q.isEmpty()){
            
            Vertex curr = q.poll();
            
            if(curr.source == dst){
                return curr.cost;
            }
            
            if(curr.dest<K){
                List<int []> nexts = flightPath.getOrDefault(curr.source, new ArrayList<int[]>());
                
                for(int[] next: nexts){
                    q.add(new Vertex(next[0], curr.cost+next[1], curr.dest+1));
                }
            }
        }     
        return -1;
    }
}
