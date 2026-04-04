class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0,right=row*col-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int ele=matrix[mid/col][mid%col];
            if(ele==target)return true;
            else if(ele>target)right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}
