public int[] shortestPath(int N,int M, int[][] edges) {
		//Code her
		ArrayList<ArrayList<Pair>> al = new ArrayList<>();
		
		for(int i=0;i<N;i++)
		{
		    al.add(new ArrayList<Pair>());
		}
		
		for(int i=0;i<M;i++)
		{
		    
		    al.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		    
		    
		}
		
		int distance[]= new int[N];
		for(int i=0;i<N;i++) distance[i]=(int)1e9;
		
		distance[0]=0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.d-b.d));
		
		pq.add(new Pair(0,0));
		while(pq.size()>0)
		{
		    Pair curr= pq.remove();
		    int node = curr.v;
		    int dis= curr.d;
		    for(int i=0;i<al.get(node).size();i++)
		    {
		        int  val = al.get(node).get(i).v;
		        int tdst = al.get(node).get(i).d;
		        
		        if(distance[node]+tdst < distance[val])
		        {
		            distance[val]= distance[node]+tdst;
		            pq.add(new Pair(val , distance[val]));
		        }
		        
		    }
		    
		}
		for(int i=0;i<N;i++)
		{
		    if(distance[i]==(int)1e9)
		    {
		        distance[i]=-1;
		    }
		}
		return distance;
	 
	}
