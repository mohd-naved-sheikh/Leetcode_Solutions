class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1==null || word1.length()<=0) return word2;
        if(word2==null || word2.length()<=0) return word1;

        StringBuilder s = new StringBuilder();
        int n= Math.max(word1.length(),word2.length());
        for(int i=0;i<n;i++){
           if(i<word1.length()){
            s.append(word1.charAt(i));
           }

           if(i<word2.length()){
            s.append(word2.charAt(i));
           }
           
           
            }
        return s.toString();
    }
}