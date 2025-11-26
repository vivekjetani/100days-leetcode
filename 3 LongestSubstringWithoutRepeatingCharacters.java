class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        for(int i = 0; i < 128; i++) hash[i] = -1;
        char[] ch = s.toCharArray();
        int  maxLen = 0 , i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(hash[ch[j]] >= i) {
                i = hash[ch[j]] + 1;
            }
            hash[ch[j]] = j;
            maxLen = Math.max(maxLen , j - i + 1);
        }
        return maxLen;
    }
}