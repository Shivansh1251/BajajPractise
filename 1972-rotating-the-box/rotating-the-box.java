class Solution {
    void shiftRight(char arr[],int n){
        int l=0,r=0;
        while(r<n){
            while(l<n&&arr[l]!='#'){
                l++;
                r++;
            }
            while(r<n&&arr[r]!='.'){
                if(arr[r]=='*'){
                    r++;
                    l=r;
                    continue;
                }
                r++;
            }

            if(l<n&&arr[l]=='#'&&r<n&&arr[r]=='.'){
                arr[r]='#';
                arr[l]='.';
            }

            l++;
            r++;
        }
    }
    void rev(char arr[],int l,int r){
        while(l<r){
            char temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n=boxGrid.length;
        int m=boxGrid[0].length;

        for(int i=0;i<n;i++){
            shiftRight(boxGrid[i],m);
        }

        char ans[][]=new char[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=boxGrid[j][i];
            }
            rev(ans[i],0,n-1);
        }

        return ans;
    }
}