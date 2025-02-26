public class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            
            int lenS = 0, lenW = 0;
            char charS = s.charAt(i), charW = word.charAt(j);
            
            while (i < s.length() && s.charAt(i) == charS) {
                lenS++;
                i++;
            }
            
            while (j < word.length() && word.charAt(j) == charW) {
                lenW++;
                j++;
            }
            
            if (lenS < lenW || (lenS > lenW && lenS < 3)) {
                return false;
            }
        }
        
        return i == s.length() && j == word.length();
    }
}
