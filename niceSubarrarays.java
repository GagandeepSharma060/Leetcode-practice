class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int sum=0;
        int ans=0;;
        
        int l=0;int r=0;
      //  int t=nums.length;
        int cnt=0;
        int num=0;
        while(r<nums.length)
        {

            if(nums[r]%2==1)
            {
                  cnt=0;
                  num++;
                  
            }
            while(num==k )
            {
            //    l++;
                cnt++;
                num=num-(nums[l++]&1);


            }
              r++;
            ans=ans+cnt;
        }
        return ans;
     


        
    }
}
