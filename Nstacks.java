import java.util.* ;
import java.io.*; 
public class NStack {
    // Initialize your data structure.

    int arr[];
    int top[];
    int next[];

    int free;
    int n;
    public NStack(int N, int S) {
      n=N;
      free=0;
      arr= new int[S];
      top= new int[N+1];
      next= new int[S];

      Arrays.fill(top,-1);

      for(int i=0;i<S;i++)
      {
          next[i]=i+1;
      }
      next[S-1]=-1;
        
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // Write your code here.

        if(free==-1)
        {
            return false;
        }

        int index= free;

free =next[index];
        arr[index]=x;

        
         next[index]=top[m-1];

         top[m-1]=index;

         return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Write your code here.

        if(top[m-1]==-1) return -1;

        int index= top[m-1];

        top[m-1]=next[index];

        next[index]=free;
        free=index;

        return arr[index];
    }
}
