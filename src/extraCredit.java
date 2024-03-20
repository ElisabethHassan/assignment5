public class extraCredit {
    public int[] sumTarget(int[] arr, int k){
        int[] res = {-1, -1};
        int total = 0;

        int l = 0;
        int r = 0;

        while(r < arr.length){
            total += arr[r];

            //if the total is greater than target
            //and still in bounds
            //decrease the total and move the left pointer
            while(total > k && l <= r){
                total -= arr[l];
                l++;
            }

            //check if the values match the target
            if(total == k){
                res[0] = l;
                res[1] = r;
                return res;
            }

            //increase the right value
            r++;
        }


        return res;

    }
}
