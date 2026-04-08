class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // If it's red, swap it to the front
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // If it's white, just move the current pointer
                mid++;
            } else {
                // If it's blue, swap it to the back
                swap(nums, mid, high);
                high--;
                // Don't increment mid here, because the swapped value 
                // from 'high' needs to be inspected.
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}