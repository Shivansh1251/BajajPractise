class Solution {
    int preIdx=0;
    int find(int arr[],int t,int l,int r){
        for(int i=l;i<=r;i++){
            if(arr[i]==t)return i;
        }
        return -1;
    }
    public TreeNode buildTree(int[] pre,int[] in,int inLeft,int inRight){
        if(inLeft>inRight)return null;

        TreeNode root=new TreeNode(pre[preIdx]);
        int inRoot=find(in,pre[preIdx],inLeft,inRight);
        preIdx++;

        root.left=buildTree(pre,in,inLeft,inRoot-1);
        root.right=buildTree(pre,in,inRoot+1,inRight);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,inorder.length-1);
    }
}