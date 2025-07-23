class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return process(s, "ab", x, "ba", y);
        } else {
            return process(s, "ba", y, "ab", x);
        }
    }

    private int process(String s, String first, int firstVal, String second, int secondVal) {
        int total = 0;
        Stack<Character> stack1 = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (!stack1.isEmpty() && stack1.peek() == first.charAt(0) && ch == first.charAt(1)) {
                stack1.pop();
                total += firstVal;
            } else {
                stack1.push(ch);
            }
        }

        Stack<Character> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            char ch = stack1.pop();
            if (!stack2.isEmpty() && ch == second.charAt(0) && stack2.peek() == second.charAt(1)) {
                stack2.pop();
                total += secondVal;
            } else {
                stack2.push(ch);
            }
        }

        return total;
    }
}
