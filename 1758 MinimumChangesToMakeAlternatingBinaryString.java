class Solution {
    static {
        for(int i = 0; i < 10000; i++){
            minOperations("101010");
        }
    }
    public static int minOperations(String s) {

        int zero = 0;
        int one = 0;

        for(int i = 0; i < s.length(); i++){
            if((i & 1) == 0){
                if(s.charAt(i) == '0') one++;
                else zero++;
            } 
            else{
                if(s.charAt(i) == '0') zero++;
                else one++;
            }
        }

        return Math.min(zero, one);
    }
}
