class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int m=arr1.length-1;
        int n=arr2.length-1;
        int count =0;
        for(int i=0;i<=m;i++){
            
        boolean flag=true;
            for(int j=0;j<=n;j++){
              if(Math.abs(arr1[i]-arr2[j])<=d){

              flag=false;
              break;
              
               }
               }
               if(flag) count++;
            
        } 
        return count;
    }
}