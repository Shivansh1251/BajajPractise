class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        int n=nums.length;
        if(n<3)return -1;
        for(int i=0;i<n;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],new ArrayList<>());
            }
            mp.get(nums[i]).add(i);
        }
        int minDiff=Integer.MAX_VALUE;
        for(int i:mp.keySet()){
            List<Integer> ls=mp.get(i);
            int s=ls.size();
            if(s>=3){
                for(int idx=2;idx<s;idx++){
                    int diff=2*(ls.get(idx)-ls.get(idx-2));
                    minDiff=minDiff>diff?diff:minDiff;
                }
            }
        }
        return minDiff==Integer.MAX_VALUE?-1:minDiff;
    }
}