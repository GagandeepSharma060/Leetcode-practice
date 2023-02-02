class Solution {


    public static boolean dfs(int v  , ArrayList<ArrayList<Integer>> adj , boolean[]vis , boolean []path, boolean[] safe)
    {
        
        vis[v]=true;
        path[v]=true;
        
        for(int nb: adj.get(v))
        {
            if(vis[nb]!=true)
            {
                if(dfs(nb, adj , vis , path, safe))
                {
                    return true;
                }
            }else if(path[nb]==true)
            {
                return true;
            }
        }
        
        safe[v]=true;
        path[v]=false;
        return false;
        
        
        
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<graph.length;i++)
        {
                al.add(new ArrayList<Integer>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int a: graph[i])
            {
                al.get(i).add(a);
            }
        }

        boolean vis[]= new boolean[n];
        boolean path[]= new boolean[n];
        boolean safe[]= new boolean[n];
      //  Arrays.fill(safe,true);

        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
                dfs(i,al,vis,path,safe);
            }

        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(safe[i]) ans.add(i);
        }
        return ans;
        
    }
}
