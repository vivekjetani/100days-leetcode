class Solution {
    public int countOdds(int low, int high) {
    
        if(low%2!=0 && high%2!=0){
            return (int) ((((high-low)+1)/2)+1);            
        }
        
        return (int) ((((high-low)+1)/2));
                
    }
}