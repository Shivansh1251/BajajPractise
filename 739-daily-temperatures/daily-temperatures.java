class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int ans[]=new int[n];
        
        Stack<int[]> st=new Stack<>();

        for(int i=0;i<n;i++){
            int curr=temp[i];
            while(!st.isEmpty()&&st.peek()[1]<curr){
                int []t=st.pop();
                ans[t[0]]=i-t[0];
            }
            st.push(new int[]{i,curr});
        }

        return ans;
    }
}
