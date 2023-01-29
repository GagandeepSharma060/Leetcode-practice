class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n=mat.length;int m=mat[0].length;
        Queue<int[]> que = new ArrayDeque<>();
         int[][] ans = new int[n][m];
         boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++)
        {
           for(int j=0;j<m;j++)
           {
               if(mat[i][j]==0)
               {
                   que.add(new int[]{i,j,0});
                   visited[i][j]=true;
               }
           }
        }

        while(que.size()>0)
        {

           int temp[] = que.remove();
           

           int i=temp[0];
           int j= temp[1];
           int k=temp[2];
           System.out.println(i+" "+j+" "+k);

           ans[i][j]=k;
           visited[i][j]=true;

           int nr , nc;

           nr = i-1;nc=j;
           if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false && mat[nr][nc]==1)
           {
               visited[nr][nc]=true;
               que.add(new int[]{nr,nc,k+1});
           }
           nr = i+1;nc=j;
           if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false &&  mat[nr][nc]==1)
           {
               visited[nr][nc]=true;
               que.add(new int[]{nr,nc,k+1});
           }
           nr = i;nc=j-1;
           if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false && mat[nr][nc]==1)
           {
               visited[nr][nc]=true;
               que.add(new int[]{nr,nc,k+1});
           }

           nr = i;nc=j+1;
           if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false &&  mat[nr][nc]==1)
           {
               visited[nr][nc]=true;
               que.add(new int[]{nr,nc,k+1});
           }




        }
        return ans;
    }
}
