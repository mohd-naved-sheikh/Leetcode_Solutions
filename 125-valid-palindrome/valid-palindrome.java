class Solution {
    public boolean isPalindrome(String s) {
      String s2 =   s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int j=s2.length()-1;
        int i=0;
         while(i<j){
            if(s2.charAt(i)!=s2.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}