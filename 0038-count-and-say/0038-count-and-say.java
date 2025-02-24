public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            char[] chars = result.toCharArray();
            int count = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == chars[j - 1]) {
                    count++;
                } else {
                    next.append(count).append(chars[j - 1]);
                    count = 1;
                }
            }
            next.append(count).append(chars[chars.length - 1]);
            result = next.toString();
        }
        return result;
    }
}
