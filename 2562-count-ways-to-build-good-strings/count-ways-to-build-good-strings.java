class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1000000007;
        long[] dp = new long[high + 1];
        dp[0] = 1;
        for(int i = 1; i <= high; i++){
            if(i >= zero){
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if(i >= one){
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
        }
        long ans = 0;
        for(int i = low; i <= high; i++){
            ans = (ans + dp[i]) % MOD;
        }
        return (int)ans;
    }
}