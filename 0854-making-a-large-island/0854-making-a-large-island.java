import java.util.*;

class Solution {
    private int[][] grid;
    private int n;
    private int[] dr = new int[]{-1, 1, 0, 0};
    private int[] dc = new int[]{0, 0, -1, 1};
    private int[][] islandIds;
    private Map<Integer, Integer> islandSizes;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.islandIds = new int[n][n];
        this.islandSizes = new HashMap<>();
        int islandId = 1;
        int maxIslandSize = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && islandIds[r][c] == 0) {
                    int size = dfs(r, c, islandId);
                    islandSizes.put(islandId, size);
                    maxIslandSize = Math.max(maxIslandSize, size);
                    islandId++;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            neighborIslands.add(islandIds[nr][nc]);
                        }
                    }
                    int totalSize = 1;
                    for (int id : neighborIslands) {
                        totalSize += islandSizes.get(id);
                    }
                    maxIslandSize = Math.max(maxIslandSize, totalSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int dfs(int r, int c, int islandId) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1 || islandIds[r][c] != 0) {
            return 0;
        }
        islandIds[r][c] = islandId;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            size += dfs(r + dr[i], c + dc[i], islandId);
        }
        return size;
    }
}