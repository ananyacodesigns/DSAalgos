/*

K CLOSEST POINTS TO ORIGIN

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

  */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //QuickSelect algorithm which is a different form of quick sort
        int left=0, right = points.length -1;
        while(left<=right){
            int pivotIndex = partition(points, left, right);
            if(pivotIndex == k-1){
                break;
            }
            else if(pivotIndex<k -1){
                left = pivotIndex + 1;
            }
            else {
                right= pivotIndex-1;
            }
        }
        int[][] result = new int[k][2];
        for(int i = 0; i<k ; i++){
            result[i] = points[i];
        }
        return result;
    }

    private int partition(int[][] points, int left, int right){
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        int[] pivotPoint = points[pivotIndex];
        swap(points, pivotIndex, right);

        int i = left;
        for(int j = left; j<right; j++){
            if(compare(points[j], pivotPoint)<0){
                swap(points, i++,j);
            }
        }
        swap(points, i, right);
        return i;
    }
    private int compare(int[] point1, int[] point2){
        return(point1[0]*point1[0]+ point1[1]*point1[1]) - (point2[0]*point2[0] +point2[1]*point2[1]);
    }
    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
} 
