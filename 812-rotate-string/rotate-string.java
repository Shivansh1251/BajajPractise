class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        String test=s+s;
        return test.contains(goal);
    }
}