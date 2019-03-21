/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (36.14%)
 * Total Accepted:    194.5K
 * Total Submissions: 526.3K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] requires =
		new List[numCourses];
	for (int i = 0; i < numCourses; i++) {
            requires[i] = new ArrayList<Integer>();
	}
        int[] indegree = new int[numCourses];
	Queue<Integer> readyCourses = new LinkedList<>();
	int finishCount = 0;
	for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
	    int preCourse = prerequisites[i][1];
	    requires[preCourse].add(course);
            indegree[course]++;
	}
	for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                readyCourses.offer(i);
	    }
	}
	while (!readyCourses.isEmpty()) {
            int course = readyCourses.poll();
	    finishCount++;
	    for (int unblockedCourse : requires[course]) {
                indegree[unblockedCourse]--;
		if (indegree[unblockedCourse] == 0) {
                    readyCourses.offer(unblockedCourse);
		}
	    }
	}
	return finishCount == numCourses;
    }
}
