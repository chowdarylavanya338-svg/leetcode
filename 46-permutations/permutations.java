import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result) {
        
        // Base case
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;          // choose
            curr.add(nums[i]);

            backtrack(nums, visited, curr, result);

            curr.remove(curr.size() - 1); // un-choose
            visited[i] = false;
        }
    }
}