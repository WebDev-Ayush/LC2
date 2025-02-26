public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int totalLines = 1, currentWidth = 0;
        
        for (char c : s.toCharArray()) {
            int letterWidth = widths[c - 'a'];
            if (currentWidth + letterWidth > 100) {
                totalLines++;
                currentWidth = letterWidth;
            } else {
                currentWidth += letterWidth;
            }
        }
        
        return new int[] {totalLines, currentWidth};
    }
}
