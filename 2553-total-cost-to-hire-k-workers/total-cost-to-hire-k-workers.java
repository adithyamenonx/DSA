import java.util.*;
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int l = 0; 
        int r = n - 1;
        for(int i = 0; i < candidates && l <= r; i++){
            left.offer(costs[l++]);
        }
        for(int i = 0; i < candidates && l <= r; i++){
            right.offer(costs[r--]);
        }
        long ans = 0;
        for(int i = 0;i < k; i++){
            if(right.isEmpty() || !left.isEmpty() && left.peek() <= right.peek()){
                ans += left.poll();
                if(l <= r){
                    left.offer(costs[l++]);
                }
            
        }else{
            ans += right.poll();
            if(l <= r){
                right.offer(costs[r--]);
            }
        }
    }
    return ans;
}}