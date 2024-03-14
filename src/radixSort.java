public class radixSort {

    //gets the max number
    private static int getMax(String[] arr) {
        int max = arr[0].length();
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }


    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private static void countSort(String[] arr, int exp) {
        int n = arr.length;
        String[] output = new String[n]; // output array
        int[] count = new int[256];

        // Store count of occurrences in count[]
        for (String s : arr) {
            int index = (s.length() <= exp) ? 0 : (Character.isUpperCase(s.charAt(s.length() - exp - 1)) ? s.charAt(s.length() - exp - 1) + 128 : s.charAt(s.length() - exp - 1));
            count[index]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output[]
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = (arr[i].length() <= exp) ? 0 : (Character.isUpperCase(arr[i].charAt(arr[i].length() - exp - 1)) ? arr[i].charAt(arr[i].length() - exp - 1) + 128 : arr[i].charAt(arr[i].length() - exp - 1));
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        System.arraycopy(output, 0, arr, 0, n);
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    public static void radixSort(String[] arr) {
        // Find the maximum length of string to know the number of digits
        int max = getMax(arr);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is the current digit number
        for (int exp = max; exp > 0; exp--) {
            countSort(arr, exp - 1);
        }
    }

    // A utility function to print an array
    private static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }



}
