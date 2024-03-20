import java.util.HashMap;

public class Q6_subInteger {

    public static String isSubset(int[] s, int[] t) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        //stores the frequency of each value in t in a hashmap
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
            //else subtract freq by 1 to show that you have seen the value
            hashMap.put(value, hashMap.get(value) - 1);
        }

        return "Yes";
    }

}
