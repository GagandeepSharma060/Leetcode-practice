public int sum(int inx)
{
 int sum=0
 while(idx>0)
 {
 
  sum+=arr[idx];
  idx=idx-(idx&-idx);
 }
 
 return sum;


}

void update(int val , int idx)
{

   while(idx<N)
   {
   
           arr[idx]+=val;
           id=idx+(idx&-idx);
   }


}
