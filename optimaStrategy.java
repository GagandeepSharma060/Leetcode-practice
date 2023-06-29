
class solve
{
    static int help(int s, int e,int [][]dp,int []arr)
    {
        if(s>e) return 0;
        
        if(dp[s][e]!=-1) return dp[s][e];
        
        
        return dp[s][e]=Math.max(arr[s]+Math.min(help(s+2,e,dp,arr),help(s+1,e-1,dp,arr)),arr[e]+Math.min(help(s+1,e-1,dp,arr),help(s,e-2,dp,arr)));
        
    }
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        
        int dp[][]= new int[n][n];
        
        for(int a[]:dp)
        {
            Arrays.fill(a,-1);
        }
        return help(0,n-1,dp,arr);
    }
}
