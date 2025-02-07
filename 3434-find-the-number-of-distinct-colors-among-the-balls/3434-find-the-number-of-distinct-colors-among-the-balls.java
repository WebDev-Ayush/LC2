import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> ballColors = new HashMap<>();
        HashMap<Integer, Integer> colorFrequency = new HashMap<>();
        HashSet<Integer> distinctColors = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            if (ballColors.containsKey(x)) {
                int oldColor = ballColors.get(x);
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                if (colorFrequency.get(oldColor) == 0) {
                    distinctColors.remove(oldColor);
                }
            }

            ballColors.put(x, y);
            colorFrequency.put(y, colorFrequency.getOrDefault(y, 0) + 1);
            distinctColors.add(y);

            result[i] = distinctColors.size();
        }

        return result;
    }
}