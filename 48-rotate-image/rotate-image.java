class Solution {
    void revArray(int []arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            arr[left]=arr[left]^arr[right];
            arr[right]=arr[left]^arr[right];
            arr[left]=arr[left]^arr[right];
            left++;
            right--;
        }
    }
    
    void transpose(int [][]mat){
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat[i].length;j++){
                mat[i][j]^=mat[j][i];
                mat[j][i]=mat[i][j]^mat[j][i];
                mat[i][j]^=mat[j][i];
            }
            revArray(mat[i]);
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
    }
}