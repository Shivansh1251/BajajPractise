class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        
        for(int i:answers){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }

        int count=0;

        for(int i:mp.keySet()){
            int temp=mp.get(i);
            count+=((i+1)*((temp+i)/(i+1))); 
        }

        return count;
    }
}