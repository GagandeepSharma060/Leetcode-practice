class Solution {
    public String shortestPalindrome(String s) {
        

        if(s.length()<=1) return s;
        String new_s = s+"#"+new StringBuilder(s).reverse().toString();
        int[] position = new int[new_s.length()];

     

        for(int i=1;i<new_s.length();i++)
        {

           int len = position[i-1];
           while(len>0 && new_s.charAt(i)!=new_s.charAt(len))
           {
               len= position[len-1];
           }

           if(len==0)
           {
               position[i]=0;
                if( new_s.charAt(i)==new_s.charAt(len))
               {
                   position[i]++;
               }
           }else{
               position[i]=len;
               if( new_s.charAt(i)==new_s.charAt(len))
               {
                   position[i]++;
               }
           }



        }

               return new StringBuilder(s.substring(position[position.length-1])).reverse().toString()+s;
    }
}
