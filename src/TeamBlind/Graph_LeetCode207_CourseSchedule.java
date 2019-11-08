package TeamBlind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_LeetCode207_CourseSchedule {

	public static void main(String[] args) {
		Graph_LeetCode207_CourseSchedule ob = new Graph_LeetCode207_CourseSchedule();
		System.out.println(ob.canFinish(2, new int[][] {{0,1},{1,0}}));

	}
	
	 static boolean isPossible = true;
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        isPossible = true;
	        Map<Integer, List<Integer>> adj = new HashMap<>();
	        
	        for( int[] edge : prerequisites){
	            adj.computeIfAbsent(edge[0], x-> new ArrayList<Integer>()).add(edge[1]);
	        }
	        
	        int visited[] = new int[numCourses];
	        for(int i=0; i< numCourses; i++){
	            if(visited[i] == 0){
	                dfs(i, adj, visited);
	            }
	        }
	        return isPossible;
	    }
	    
	    void dfs(Integer src, Map<Integer, List<Integer>> adj, int[] visited ){
	        if(!isPossible)
	            return;
	        
	        visited[src] = 1;
	        
	        for(Integer neighbour : adj.getOrDefault(src, new ArrayList<Integer>())){
	            
	            if(visited[neighbour] == 2){
	                continue;
	            }else if (visited[neighbour] == 1){
	                isPossible = false;
	                return;
	            }else{
	                dfs(neighbour, adj, visited);
	            }   
	        }
	        visited[src] = 2;
	    }

}
