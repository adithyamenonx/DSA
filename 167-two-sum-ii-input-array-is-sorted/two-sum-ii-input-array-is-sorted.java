class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        while(start<end){
            int first=numbers[start];
            int second=numbers[end];
            int sum=first+second;
            if(sum==target){
                return new int[] {start+1,end+1};
            }
            else if(sum<target){
                start=start+1;
            }
            else{
                end=end-1;
            }
        }
        return new int[0];
    }
}