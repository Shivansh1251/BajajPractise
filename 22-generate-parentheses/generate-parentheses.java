class Solution {
    void back(List<String> ls,StringBuilder curr,int open,int close){
        if(open==0 && close==0){
            ls.add(curr.toString());
        }

        if(open!=0){
            curr.append("(");
            back(ls,curr,open-1,close);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close>open){
            curr.append(")");
            back(ls,curr,open,close-1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ls=new ArrayList<>();

        back(ls,new StringBuilder(),n,n);

        return ls;
    }
}