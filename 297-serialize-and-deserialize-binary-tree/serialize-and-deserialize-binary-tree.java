public class Codec {

    // Encodes a tree to a single string.
    void preorder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }
    
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String preorder[]=data.split(",");
        return buildTree(preorder);
    }

    int preIdx=0;
    public TreeNode buildTree(String[] preorder) {
        
        TreeNode root=null;
        if(!preorder[preIdx].equals("N")){
            root=new TreeNode(Integer.parseInt(preorder[preIdx]));
            preIdx++;
            root.left=buildTree(preorder);
            root.right=buildTree(preorder);
        }else{
            preIdx++;
        }

        return root;
    }
}
