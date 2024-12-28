class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int maxSoFar = A[0] + 0;
        
        for (int j = 1; j < A.length; j++) {
            maxScore = Math.max(maxScore, maxSoFar + A[j] - j);
            maxSoFar = Math.max(maxSoFar, A[j] + j);
        }
        
        return maxScore;
    }
}