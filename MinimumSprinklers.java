class Pair{
    int st;
    int end;
    Pair(int i,int j)
    {
        st=i;
        end=j;
    }
}
class Solution
{
    
    int min_sprinklers(int arr[], int n)
    {
        // code here
        
        Pair p[]= new Pair[n];
        
        for(int i=0;i<n;i++)
        {
            p[i]= new Pair(Math.max(0,i-arr[i]),Math.min(n-1,i+arr[i]));
        }
        
        Arrays.sort(p,(a,b)->{
           
           if(a.st==b.st)
           {
               return a.end-b.end;
           }
           return a.st-b.st;
            
        });
        
        int st=0;
        int i=0;
        int ans=0;
        
        while(st<n)
        {
            
            int max=Integer.MIN_VALUE;
            
            while( i<n&& p[i].st<=st)
            {
                max=Math.max(max,p[i].end);
                i++;
                
            }
            
            if(max==Integer.MIN_VALUE)
            {
                return -1;
            }
            
            ans++;
            
            st=max+1;
            
            
        }
        
        return ans;
        
        
    }
}
