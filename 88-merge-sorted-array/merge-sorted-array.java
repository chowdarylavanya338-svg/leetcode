class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for nums1, nums2, and the placement position
        int i = m - 1;     // Last valid element in nums1
        int j = n - 1;     // Last element in nums2
        int k = m + n - 1; // Last position in nums1 total capacity

        // Compare elements from the back and move the larger one to the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them
        // (If elements remain in nums1, they are already in their correct place)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}