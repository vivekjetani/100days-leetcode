class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) arr[i] += 10001 * Integer.bitCount(arr[i]);
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) arr[i] %= 10001;
        return arr;
    }
}
