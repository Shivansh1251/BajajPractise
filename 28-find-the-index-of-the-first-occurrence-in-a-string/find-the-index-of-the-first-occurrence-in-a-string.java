class Solution {
    int[] createLps(String s,int len){

        int []lps=new int[len];
        int i=1;
        int prev=0;
        while(i<len){
            if(s.charAt(i)==s.charAt(prev)){
                lps[i]=prev+1;
                prev+=1;
                i+=1;
            }
            else if(prev==0){
                lps[i]=0;
                i+=1;
            }
            else{
                prev=lps[prev-1];
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();

        int []lps=createLps(needle,m);

        int i=0;
        int j=0;
        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else if(j==0){
                i++;
            }
            else{
                j=lps[j-1];
            }

            if(j==m){
                return i-m;
            }
        }

        return -1;
    }
}