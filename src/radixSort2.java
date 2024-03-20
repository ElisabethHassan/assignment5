public class radixSort2 {


    private static void countSort(String[] arr, int exp) {
        int n = arr.length;
        String[] res = new String[n]; // resulting array
        int[] count = new int[256];  // 256 for all possible ASCII values

        // Store count of occurrences in count[]
        for (String s : arr) {
            int index = (s.length() <= exp) ? 0 : s.charAt(s.length() - exp - 1);
            count[index]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this digit in res[]
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the res array
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i].length() <= exp) ? 0 : arr[i].charAt(arr[i].length() - exp - 1);
            res[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(res, 0, arr, 0, n);
    }


    //returns the max string length
    //TC = O(n)
    private static int getMax(String[] arr) {
        int max = arr[0].length();
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    // implementation of radixSort
    public static String[] radixSort(String[] arr) {
        int max = getMax(arr); // get the max length of string

        for (int exp = 1; exp <= max; exp++) { // Iterate from least significant digit to most significant
            countSort(arr, exp); // Pass the current digit being considered
        }
        return arr;
    }


    // prints the array
    //TC = O(n)
    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }


}
