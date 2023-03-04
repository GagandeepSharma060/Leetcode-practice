class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0;

        int lmin=-1;
        int lmax=-1;

        int lb=-1;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=minK && nums[i]<=maxK)
            {
                if(nums[i]==minK)
                {
                    lmin=i;

                }
                if(nums[i]==maxK)
                {
                    lmax=i;
                }

                ans+=Math.max(0,Math.min(lmin,lmax)-lb);
            }
            else{
                lmin=-1;
                lmax=-1;
                lb=i;
            }
        }
        return ans;
    }
}
