int maximalNetworkRank(int n, int** roads, int roadsSize, int* roadsColSize) {
    int degree[n];
    for(int i = 0; i < n; i++){
        degree[i] = 0;
    }
    for(int i = 0; i < roadsSize; i++){
        int a = roads[i][0];
        int b = roads[i][1];
        degree[a]++;
        degree[b]++;
    }
    int ans = 0;

    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            int rank = degree[i] + degree[j];
            for(int k = 0; k < roadsSize; k++){
                if((roads[k][0] == i && roads[k][1] == j) ||
                   (roads[k][0] == j && roads[k][1] == i)){
                    rank--;
                    break;
                  }
            }
            if (rank > ans){
                ans = rank;
            }
        }
    }
    return ans;
}