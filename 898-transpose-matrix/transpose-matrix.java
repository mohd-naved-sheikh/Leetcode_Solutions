class Solution {
    public int[][] transpose(int[][] matrix) {
        int i=matrix.length;
        int j=matrix[0].length;
        int[][] result = new int [j][i];

        for(int k=0;k<i;k++){
            for(int l=0;l<j;l++){
                 result [l][k] = matrix[k][l];
            }
        }
        return result;
    }
}