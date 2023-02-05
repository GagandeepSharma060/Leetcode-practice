class Solution {
    public static boolean isPossible(int sum , int[] arr, int k)
    {
        int part=1;
        int csum=0;
        for(int i=0;i<arr.length;i++)
        {
            if(csum+arr[i]<=sum)
            {
                csum+=arr[i];
            }else{
                csum=arr[i];
                part++;
            }
        }
        return part<=k;
            }
    public int splitArray(int[] nums, int k) {
     int n=nums.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int a:nums)
        {
            sum+=a;
            max=Math.max(max,a);
        }
        if(k==n) return max;
        if(k==1) return sum;
        int start = max;
        int end= sum;
        int ans= sum;
        while(start <=end)
        {
            int mid = start+(end-start)/2;

            if(isPossible(mid , nums, k))
            {
                ans= mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return ans;
        
    }
}
