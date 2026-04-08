 class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Using modulo handles the "wrap around" case: 
        // if low == letters.length, it returns letters[0]
        return letters[low % letters.length];
    }
}   