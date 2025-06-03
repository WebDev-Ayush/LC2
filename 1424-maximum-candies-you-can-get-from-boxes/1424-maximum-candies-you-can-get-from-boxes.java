import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] opened = new boolean[n];
        boolean[] seen = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            queue.offer(box);
            seen[box] = true;
        }

        int totalCandies = 0;
        boolean progress = true;

        while (progress) {
            progress = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int box = queue.poll();

                
                if (status[box] == 1 || hasKey[box]) {
                    if (opened[box]) continue;
                    opened[box] = true;
                    totalCandies += candies[box];
                    progress = true;

                    
                    for (int key : keys[box]) {
                        if (!hasKey[key]) {
                            hasKey[key] = true;
                            if (seen[key] && !opened[key]) {
                                queue.offer(key);
                            }
                        }
                    }

                    
                    for (int b : containedBoxes[box]) {
                        if (!seen[b]) {
                            seen[b] = true;
                            queue.offer(b);
                        } else if (!opened[b]) {
                            queue.offer(b);
                        }
                    }
                } else {
                
                    queue.offer(box);
                }
            }
        }

        return totalCandies;
    }
}
