class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int cur = 0, max = nums[0];

        for(int n : nums){
            cur = Math.max(n, cur + n);
            max = Math.max(max, cur);
        }

        return max;
    }
}