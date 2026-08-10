import java.util.*;
class Solution {
    long ans = 0;
    int seats;
    List<Integer>[] graph;
    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;
        int n = roads.length + 1;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads){
            int a = road[0];
            int b = road[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }
    private long dfs(int node, int parent){
        long people = 1;
        for(int next : graph[node]){
            if(next == parent)
               continue;
            long childPeople = dfs(next, node);
            ans += (childPeople + seats - 1) / seats;
            people += childPeople;
        }
        return people;
    }
}