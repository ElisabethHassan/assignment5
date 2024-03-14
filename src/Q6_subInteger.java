import java.util.HashMap;

public class Q6_subInteger {

    public static String isSubset(int[] s, int[] t) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //stores the frequency of each value in hashmap
        for (int value : t) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, 1);
            } else {
                hashMap.put(value, hashMap.get(value) + 1);
            }
        }

        // if the value in s is not in t return false
        for (int value : s) {
            if (!hashMap.containsKey(value) || hashMap.get(value) == 0) {
                return "No";
            }
            hashMap.put(value, hashMap.get(value) - 1);
        }

        return "Yes";
    }

}
