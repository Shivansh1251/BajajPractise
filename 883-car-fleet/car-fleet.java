class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;

        double arr[][]=new double[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=(double)(target-position[i])/speed[i];
        }

        Arrays.sort(arr,(a,b)->Double.compare(b[0],a[0]));

        Stack<double[]> st=new Stack<>();

        st.push(arr[0]);
        for(int i=1;i<n;i++){
            if(st.peek()[1]<arr[i][1]){
                st.add(arr[i]);
            }
        }

        return st.size();
    }
}
