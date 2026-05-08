class Solution {
    long timeToEat(int []p,int qty){
        long t=0;
        for(int i=0;i<p.length;i++){
            t+=(p[i]+qty-1)/qty;
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=piles[0];
        int ans=right;
        for(int i=1;i<piles.length;i++){
            if(right<piles[i])right=piles[i];
        }

        while(left<=right){
            int mid=(right-left)/2+left;

            long t=timeToEat(piles,mid);

            if(t<=h){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }

        return ans;

    }
}
