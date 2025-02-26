class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;
        int j = 0;

        for (int house : houses) {
            // Move j to the closest heater that is >= house position
            while (j < heaters.length - 1 && heaters[j + 1] < house) {
                j++;
            }

            // Check the distance to the closest heater
            int dist = Math.abs(house - heaters[j]);
            if (j + 1 < heaters.length) {
                dist = Math.min(dist, Math.abs(house - heaters[j + 1]));
            }

            radius = Math.max(radius, dist);
        }

        return radius;
    }
}
