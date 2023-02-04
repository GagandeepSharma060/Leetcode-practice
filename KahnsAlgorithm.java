 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
            int[] indegree= new int[V];
            
            for(ArrayList<Integer> list :adj)
            {
                for(int dest: list)
                {
                    indegree[dest]++;
                }
            }
            
            Queue<Integer> que = new LinkedList<Integer>();
            for(int i=0;i<V;i++)
            {
                if(indegree[i]==0)
                {
                    que.add(i);
                }
            }
            
            while(que.size()>0)
            {
                
               
                int node= que.peek();
                que.remove();
                al.add(node);
               //System.out.println(node);
                for(int i=0;i<adj.get(node).size();i++)
                {
                    indegree[adj.get(node).get(i)]--;
                    if(indegree[adj.get(node).get(i)]==0)
                    {
                        que.add(adj.get(node).get(i));
                    }
                }
            }
            
            int n= al.size();
            int ans[]= new int[n];
            for(int i=0;i<n;i++)
         {
             ans[i]=al.get(i);
         }
         return ans;
    }
}
