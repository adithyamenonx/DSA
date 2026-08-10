import java.util.*;
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                arr[i] = node.val;
                if(node.left != null)
                  queue.offer(node.left);
                if(node.right != null)
                  queue.offer(node.right);
            }
            ans += minSwaps(arr);
        }
        return ans;
    }

    private int minSwaps(int[] arr){
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }
        int swaps = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == sorted[i])
               continue;
            int j = map.get(sorted[i]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            map.put(arr[j], j);
            map.put(arr[i], i);
            swaps++;
        }
        return swaps;
    }
}