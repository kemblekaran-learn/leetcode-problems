// Problem Link : https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=array&

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // if there are only two elements and they adds up exactly as target
        // then return the indices directly
        if(nums.length == 2 && (nums[0] + nums[1] == target)) {
            return new int[]{0, 1};
        }

        // return solutionWithWhileAndNestedForLoop(target, nums);
        return solutionWithNestedForLoops(target, nums);
    }

    // Solution 1 : 
    // Use a while loop to process elements in nested for-loop
    // based on a flag, once the flag is false
    // get out of the loop and return the array of indices
    private int[] solutionWithWhileAndNestedForLoop(int target, int[] nums) {
        boolean shouldRun = true;
        while(shouldRun) {
            shouldRun = false;

            for(int i = 0; i < nums.length - 1; i++) {
                int firstNumber = nums[i];
                int secondNumber = nums[i + 1];

                shouldRun = target != (firstNumber + secondNumber);
                if(!shouldRun) {
                    return new int[]{i, (i + 1)};
                }

            }
        }

        return null;
    }

    // Solution 2 :
    // Use two nested for loops, loop through the first for loop for nums
    // array and work with first element, and try to add the i + 1 element
    // from the next for loop.
    private int[] solutionWithNestedForLoops(int target, int[] nums) {
        for(int i = 0; i < nums.length; i++) {

            int firstNumber = nums[i];
            for(int j = 0; j < nums.length; j++) {

                // if both indices are same, continue to next iteration as we do
                // not want to add up the same numbers
                if(i == j) continue;

                int secondNumber = nums[j];

                // if the sum matches the target then return the indices
                if(target == (firstNumber + secondNumber)) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
