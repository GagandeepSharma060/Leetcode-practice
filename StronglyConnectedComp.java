
class Solution
{
    //Function to find number of strongly connected components in the graph.4
    public static void dfs(ArrayList<ArrayList<Integer>> adh , int i , boolean[]visited , Stack<Integer> st)
    {
        visited[i]=true;
        
        for(int a : adh.get(i))
        {
            if(visited[a]==false)
            {
                dfs(adh , a , visited , st);
            }
        }
        st.add(i);
        
    }
    public void df2(ArrayList<ArrayList<Integer>> al , boolean vis[], int t )
    {
        vis[t]=true;
        for(int aa : al.get(t))
        {
            if(vis[aa]==false)
            {
                df2(al,vis,aa);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited= new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
        dfs(adj , i,visited,st);
        }
        
        
        ArrayList<ArrayList<Integer>> ad2 = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            ad2.add(new ArrayList<>());
        }
        
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                int u=i;
                int vv= adj.get(i).get(j);
                
                ad2.get(vv).add(i);
            }
        }
        
        boolean vis[]= new boolean[V];
        int ans=0;
        while(st.size()>0)
        {
            int t=st.pop();
            if(vis[t]==false)
            {
                ans++;
                df2(ad2 , vis , t);
            }
        }
        return ans;
    }
}
