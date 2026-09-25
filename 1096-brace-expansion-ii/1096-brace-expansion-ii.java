import java.util.*;

class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        this.index = 0;
        Set<String> resultSet = parseExpression(expression);
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parseExpression(String s) {
        Set<String> totalUnion = new HashSet<>();
        Set<String> currentProduct = new HashSet<>(Collections.singletonList(""));

        while (index < s.length() && s.charAt(index) != '}') {
            char ch = s.charAt(index);

            if (ch == ',') {
                totalUnion.addAll(currentProduct);
                currentProduct = new HashSet<>(Collections.singletonList(""));
                index++;
            } else if (ch == '{') {
                index++;
                Set<String> inner = parseExpression(s);
                index++;
                currentProduct = multiply(currentProduct, inner);
            } else {
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && Character.isLowerCase(s.charAt(index))) {
                    sb.append(s.charAt(index++));
                }
                currentProduct = multiply(currentProduct, Collections.singleton(sb.toString()));
            }
        }

        totalUnion.addAll(currentProduct);
        return totalUnion;
    }

    private Set<String> multiply(Set<String> setA, Set<String> setB) {
        Set<String> result = new HashSet<>();
        for (String a : setA) {
            for (String b : setB) {
                result.add(a + b);
            }
        }
        return result;
    }
}