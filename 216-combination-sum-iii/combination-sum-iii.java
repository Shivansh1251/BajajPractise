class Solution {
    public void func(int k,int n,List<List<Integer>> result,List<Integer> curr,int idx,int sum){
        if(curr.size()==k&&sum==n){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<=9;i++){
            if(sum+i>n)break;
            curr.add(i);
            func(k,n,result,curr,i+1,sum+i);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        
        func(k,n,result,new ArrayList<>(),1,0);

        return result;
    }
}