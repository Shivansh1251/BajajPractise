class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count=0;
        int ans=0;

        for(char ch:moves.toCharArray()){
            switch(ch){
                case 'L':
                    ans++;
                    break;
                case 'R':
                    ans--;
                    break;
                default:
                    count++;
                    break;
            }
        }

        return Math.abs(ans)+count;
    }
}