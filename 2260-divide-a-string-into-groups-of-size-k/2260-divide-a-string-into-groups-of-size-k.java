class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] result = new String[groups];
        
        for (int i = 0; i < groups; i++) {
            int start = i * k;
            int end = Math.min(start + k, n);
            StringBuilder group = new StringBuilder(s.substring(start, end));
            while (group.length() < k) {
                group.append(fill);
            }
            result[i] = group.toString();
        }
        
        return result;
    }
}
