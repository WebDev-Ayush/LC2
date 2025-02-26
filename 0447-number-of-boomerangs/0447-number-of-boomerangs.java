import java.util.*;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dist = distance(points[i], points[j]);
                    distMap.put(dist, distMap.getOrDefault(dist, 0) + 1);
                }
            }
            
            for (int count : distMap.values()) {
                result += count * (count - 1); 
            }
        }
        
        return result;
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
