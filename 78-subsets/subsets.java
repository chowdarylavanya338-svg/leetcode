import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);                    // choose
            backtrack(i + 1, nums, curr, result); // explore
            curr.remove(curr.size() - 1);         // un-choose
        }
    }
}