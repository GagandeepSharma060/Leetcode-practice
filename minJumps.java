   // your code here
        if(arr.length==1)
        {
            
            return 0;
        }
        
        
        int  st=0;
        int ans=0;
        int jumps =0;
        int i=0;
        int n=arr.length;
        while(st<n-1)
        {
            
            int max=Integer.MIN_VALUE;
            
            while( i<=st)
            {
                max=Math.max(max,arr[i]+i);
                i++;
            }
            
            if(max==Integer.MIN_VALUE) return -1;
            
            ans++;
            st=max;
            
            
            
            
        }
        
        return ans;
