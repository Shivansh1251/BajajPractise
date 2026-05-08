class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int b=0;
        for(int i=1;i<heights.length;i++){
            if(heights[i-1]<heights[i]){
                pq.offer(heights[i]-heights[i-1]);
                if(pq.size()>ladders){
                    b+=pq.poll();
                    if(b>bricks){
                        return i-1;
                    }
                }
            }
        }
        return heights.length-1;
    }
}