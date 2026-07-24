import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> uSet = new HashSet<>();
        for (int num : nums) {
            uSet.add(num);
        }

        int[] u = new int[uSet.size()];
        int idx = 0;
        for (int num : uSet) {
            u[idx++] = num;
        }

        Set<Integer> s2Set = new HashSet<>();
        for (int i = 0; i < u.length; i++) {
            for (int j = i + 1; j < u.length; j++) {
                s2Set.add(u[i] ^ u[j]);
            }
        }

        int[] s2 = new int[s2Set.size()];
        idx = 0;
        for (int val : s2Set) {
            s2[idx++] = val;
        }

        Set<Integer> resultSet = new HashSet<>(uSet);
        for (int p : s2) {
            for (int val : u) {
                resultSet.add(p ^ val);
            }
        }

        return resultSet.size();
    }
}