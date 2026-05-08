class TimeMap {
    
    class Pair{
        String val;
        int time;

        Pair(String val,int time){
            this.val=val;
            this.time=time;
        }
    }

    HashMap<String,List<Pair>> mp;
    public TimeMap() {
        mp=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key))mp.put(key,new ArrayList<>());
        mp.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key))return "";
        List<Pair> ls= mp.get(key);

        int left=0;
        int right=ls.size()-1;

        String min="";

        while(left<=right){
            int mid=(right-left)/2+left;

            Pair temp=ls.get(mid);

            if(temp.time==timestamp){
                return temp.val;
            }
            else if(temp.time<timestamp){
                min=temp.val;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return min;
    }
}
