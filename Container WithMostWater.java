class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int ans=0;
        while(i<j)
        {
            int val= (j-i)*Math.min(height[i],height[j]);
            if(height[i]>height[j])
            {
                j--;
            }else{
                i++;
            }
            ans=Math.max(ans,val);
        }
        return ans;
        
    }
}
