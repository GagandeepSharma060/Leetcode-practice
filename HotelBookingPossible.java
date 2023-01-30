public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        
              Collections.sort(arrive);Collections.sort(depart);
              
              for(int i=0;i<arrive.size();i++)
              {
                  if(i+k<arrive.size())
                  {
                      if(arrive.get(i+k)<=depart.get(i))
                      {
                          return false;
                      }
                  }
              }
              return true;
    }
}
