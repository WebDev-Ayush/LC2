import java.util.Arrays;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] allRestrictions = new int[m + 2][2];
        
        System.arraycopy(restrictions, 0, allRestrictions, 0, m);
        allRestrictions[m] = new int[]{1, 0};
        allRestrictions[m + 1] = new int[]{n, n - 1};
        
        Arrays.sort(allRestrictions, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalLen = allRestrictions.length;
        
        for (int i = 1; i < totalLen; i++) {
            int dist = allRestrictions[i][0] - allRestrictions[i - 1][0];
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], allRestrictions[i - 1][1] + dist);
        }
        
        for (int i = totalLen - 2; i >= 0; i--) {
            int dist = allRestrictions[i + 1][0] - allRestrictions[i][0];
            allRestrictions[i][1] = Math.min(allRestrictions[i][1], allRestrictions[i + 1][1] + dist);
        }
        
        int maxHeight = 0;
        for (int i = 0; i < totalLen - 1; i++) {
            int id1 = allRestrictions[i][0];
            int h1 = allRestrictions[i][1];
            int id2 = allRestrictions[i + 1][0];
            int h2 = allRestrictions[i + 1][1];
            
            int peak = (id2 - id1 + h1 + h2) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        
        return maxHeight;
    }
}