class Solution {
    public int countCollisions(String directions) {
        char[] d = directions.toCharArray();
        int n = d.length;

        int left = 0, right = n - 1;

        while (left < n && d[left] == 'L') left++;
        while (right >= 0 && d[right] == 'R') right--;

        int c = 0;
        for (int i = left; i <= right; i++) {
            if (d[i] != 'S') c++;
        }
        return c;
    }
}
