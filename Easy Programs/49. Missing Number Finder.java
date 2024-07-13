/*	Write a program to given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Input nums = [3, 0, 1]
Output: 2 */


public class Main {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));  
    }
}
