package Graph;

import java.util.*;

public class CourseSch {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> catalog = new HashMap<>();
        int[] indegree = new int[numCourses];

        // Fill catalog with prerequisite
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0]; // a
            int b = prerequisites[i][1]; // requires b
            List<Integer> dep = new ArrayList<>(); // b --> a you need to take b to go to a
            if (catalog.containsKey(b)) { // this already exist
                dep = catalog.get(b);
            }
            dep.add(a);
            catalog.put(b, dep);
            indegree[a]++;
        }
        // Find out available courses
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (indegree[curr] == 0)
                count++;
            if (!catalog.containsKey(curr))
                continue;
            for (int j = 0; j < catalog.get(curr).size(); j++) {
                int currValue = catalog.get(curr).get(j);
                indegree[currValue]--;
                if (indegree[currValue] == 0)
                    queue.add(currValue);
            }
        }
        return (count == numCourses);

    }

    public static void main(String[] args) {
        int[][] input = { { 0, 1 }, { 1, 2 } };
        System.out.println(canFinish(3, input));
    }
}