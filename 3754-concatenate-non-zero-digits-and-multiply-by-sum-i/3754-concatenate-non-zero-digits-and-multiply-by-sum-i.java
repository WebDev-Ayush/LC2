class Solution {
    public long sumAndMultiply(int n) {
        String strN = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        
        for (int i = 0; i < strN.length(); i++) {
            char ch = strN.charAt(i);
            if (ch != '0' && ch != '-') {
                sb.append(ch);
                sum += (ch - '0');
            }
        }
        
        if (sb.length() == 0) {
            return 0;
        }
        
        long x = Long.parseLong(sb.toString());
        return x * sum;
    }
}