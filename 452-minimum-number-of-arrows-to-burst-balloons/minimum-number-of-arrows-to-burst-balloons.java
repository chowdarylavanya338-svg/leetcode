import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));

        int arrows = 1;
        long end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;              // need new arrow
                end = points[i][1];    // update position
            }
        }

        return arrows;
    }
}