import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


/**
 * LeetCode 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Sort array and traverse looking for duplicate.
     * If the nums array is modified it may produce side effects.
     * Need a duplicate array O(n) space.
     * 
     * Runtime: 3 ms, faster than 99.61% of Java online submissions.
     * Memory Usage: 41.9 MB, less than 96.66% of Java online submissions.
     */
    static boolean containsDuplicate(int[] nums) {

        // **** sanity checks ****
        if (nums.length == 0 || nums.length == 1)
            return false;

        // **** create local copy O(n) ****
        int[] localNums = Arrays.copyOf(nums, nums.length);
        
        // **** sort local copy  O(n log(n)) ****
        Arrays.sort(localNums);

        // **** traverse array looking for duplicates O(n) ****
        for (int i = 0; i < localNums.length - 1; i++) {
            if (localNums[i] == localNums[i + 1])
                return true;
        }

        // **** no duplicates ****
        return false;
    }


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Needs a set to check for duplicates O(n) space.
     * Uses HashSet.
     * 
     * Runtime: 11 ms, faster than 5.48% of Java online submissions
     * Memory Usage: 53.8 MB, less than 5.03% of Java online submissions
     */
    static boolean containsDuplicate1(int[] nums) {

        // **** sanity checks ****
        if (nums.length == 0 || nums.length == 1)
            return false;

        // **** initialization ****
        HashSet<Integer> hs = new HashSet<>();

        // **** traverse the array checking for duplicate entries O(n) ****
        for (int i = 0; i < nums.length; i++) {

            // **** check if in set ****
            if (hs.contains(nums[i]))
                return true;
            
            // **** add to set ****
            hs.add(nums[i]);
        }
        
        // **** no duplicates ****
        return false;
    }


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Computes and compares two sums O(2) space.
     * 
     * !!!! Works some times depending on values !!!!
     */
    static boolean containsDuplicate2(int[] nums) {

        // **** sanity checks ****
        if (nums.length == 0 || nums.length == 1)
            return false;

        // **** initialization O(2) ****
        int arrSum  = 0;
        int sum     = nums.length * (nums.length + 1) / 2;
        
        // **** compute the sum of elements in the array O(n) ****
        for (int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
        }

        // **** check is sums mismatch ****
        if (sum != arrSum)
            return true;

        // **** no duplicates ****
        return false;
    }


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Sort array and traverse looking for duplicate.
     *
     * Runtime: 3 ms, faster than 99.61% of Java online submissions.
     * Memory Usage: 42.5 MB, less than 80.96% of Java online submissions.
     */
    static boolean containsDuplicate3(int[] nums) {

        // **** sanity checks ****
        if (nums.length == 0 || nums.length == 1)
            return false;
        
        // **** sort local copy O(n log(n)) ****
        Arrays.sort(nums);

        // **** traverse array looking for duplicates O(n) ****
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }

        // **** no duplicates ****
        return false;
    }


    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Needs a set to check for duplicates O(n) space.
     * Uses HashMap.
     * 
     * Runtime: 5 ms, faster than 70.54% of Java online submissions.
     * Memory Usage: 45.1 MB, less than 44.32% of Java online submissions.
     */
    static boolean containsDuplicate4(int[] nums) {

        // **** sanity checks ****
        if (nums.length == 0 || nums.length == 1)
            return false;

        // **** initialization ****
        HashMap<Integer, Integer> hm = new HashMap<>();

        // **** traverse the array checking for duplicate entries O(n) ****
        for (int i = 0; i < nums.length; i++) {

            // **** ****
            if (hm.containsKey(nums[i]))
                return true;

            // **** ****
            hm.put(nums[i], 0);
        }
        
        // **** no duplicates ****
        return false;
    }


    /**
     * Test scaffolding.
     * !!! NOT PART OF THE SOLUTION !!!
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the line and populate array of integers ****
        int[] nums = Arrays.stream(br.readLine().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
 
        // **** close buffere reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nums: " + Arrays.toString(nums));

        // **** call function to check for duplicates and display result ****
        System.out.println("main <<< duplicates(s): " + containsDuplicate(nums));

        // **** call function to check for duplicates and display result ****
        System.out.println("main <<< duplicates(s): " + containsDuplicate1(nums));

        // **** call function to check for duplicates and display result ****
        System.out.println("main <<< duplicates(s): " + containsDuplicate2(nums));

        // **** call function to check for duplicates and display result ****
        System.out.println("main <<< duplicates(s): " + containsDuplicate3(nums));

        // **** call function to check for duplicates and display result ****
        System.out.println("main <<< duplicates(s): " + containsDuplicate4(nums));
    }
}