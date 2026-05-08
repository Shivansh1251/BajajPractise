class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++){
            if(matrix[i][m-1]>=target&&matrix[i][0]<=target){
                int left=0;
                int right=m-1;

                while(left<=right){
                    int mid=(right-left)/2+left;

                    if(matrix[i][mid]==target)return true;
                    else if(matrix[i][mid]<target){
                        left=mid+1;
                    }
                    else right=mid-1;
                }
            }
        }

        return false;
    }
}
