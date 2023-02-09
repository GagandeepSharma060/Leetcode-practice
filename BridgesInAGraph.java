class Solution {
    static int times;

    public static void dfs(int u ,int p,List<List<Integer>> adj, List<List<Integer>> al , int low[] , int[] time , boolean vis[])
    {

            vis[u]=true;
            low[u]=time[u]=times;
            times++;
           

            for(int v: adj.get(u) )
            {
                if(v==p) continue;
                if(vis[v]==true)
                {
                        low[u]=Math.min(low[u],low[v]);
                }else{

                    dfs(v,u,adj,al,low,time,vis);

                    low[u]=Math.min(low[u],low[v]);

                    if(low[v]> time[u])
                    {
                        List<Integer> tmp= new ArrayList<>();
                        tmp.add(u);
                        tmp.add(v);
                        al.add(tmp);
                    }

                }
            }



    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        int times=1;

        int low[]= new int[n];
        int time[]= new int[n];

        boolean vis[]= new boolean[n];

         List<List<Integer>> lst = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                lst.add(new ArrayList<Integer>());
            }

            for(int i=0;i<connections.size();i++)
            {
                int aa=connections.get(i).get(0);
                int bb=connections.get(i).get(1);

                lst.get(aa).add(bb);
                lst.get(bb).add(aa);
            }
    List<List<Integer>> al = new ArrayList<>();


        dfs(0,0,lst , al , low , time, vis);

        return al;
    










    }
}
