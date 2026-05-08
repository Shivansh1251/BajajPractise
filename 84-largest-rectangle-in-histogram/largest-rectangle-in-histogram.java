class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int []> st=new Stack<>();
        int n=heights.length;
        int maxArea=0;
        st.push(new int[]{0,heights[0]});
        for(int i=1;i<n;i++){
            int idx=i;
            while(!st.isEmpty()&&st.peek()[1]>heights[i]){
                int curr[]=st.pop();

                maxArea=Math.max(maxArea,(i-curr[0])*curr[1]);

                idx=curr[0];
            }
            st.push(new int[]{idx,heights[i]});
        }

        while(!st.isEmpty()){
            int curr[]=st.pop();
            maxArea=Math.max(maxArea,(n-curr[0])*curr[1]);
        }

        return maxArea;
    }
}
