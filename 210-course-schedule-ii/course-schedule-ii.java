import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            graph[prereq].add(course);
            indegree[course]++;
        }

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++] = curr;

            for (int nei : graph[curr]) {
                if (--indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        // If cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}