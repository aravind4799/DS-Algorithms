class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int res = 0,i=0;
        int countOne=0;

        while(i<n){
            if(s.charAt(i)=='0'){
                while(i+1<n && s.charAt(i+1)=='0') i++;
                res+=countOne;
            }
            else countOne++;
            i++;
        }
        return res;
    }
}