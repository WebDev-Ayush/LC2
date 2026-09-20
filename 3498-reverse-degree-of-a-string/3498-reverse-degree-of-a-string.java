class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int charValue = 'z' - s.charAt(i) + 1;
            int position = i + 1;
            total += charValue * position;
        }
        return total;
    }
}