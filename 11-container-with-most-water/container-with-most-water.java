class Solution {
    public int maxArea(int[] height) {
        int max =0;
        int l=0,r=height.length-1;
        while(l<r){
            int area = (r-l) * Math.min(height[r],height[l]);
            if(area>max) max=area;

            if(height[l]<height[r]) l++;

            else r--;
        }
        return max;
    }
}