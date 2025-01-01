class Solution {
    public int maxScore(String s) {
        int maxScore = Integer.MIN_VALUE;

        for (int k = 0; k < s.length(); k++) {
            int zero = 0;
            int one = 0;

            int i = 0;
            while (i <= k && k != s.length() - 1) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
                i++;
            }

            int j = s.length() - 1;
            while (j > k) {
                if (s.charAt(j) == '1') {
                    one++;
                }
                j--;
            }

            maxScore = Math.max(maxScore, one + zero);
        }

        return maxScore;
    }
}