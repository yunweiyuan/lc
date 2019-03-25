/*
 * @lc app=leetcode id=630 lang=java
 *
 * [630] Course Schedule III
 *
 * https://leetcode.com/problems/course-schedule-iii/description/
 *
 * algorithms
 * Hard (30.61%)
 * Total Accepted:    10.4K
 * Total Submissions: 33.4K
 * Testcase Example:  '[[100,200],[200,1300],[1000,1250],[2000,3200]]'
 *
 * There are n different online courses numbered from 1 to n. Each course has
 * some duration(course length) t and closed on dth day. A course should be
 * taken continuously for t days and must be finished before or on the dth day.
 * You will start at the 1st day.
 * 
 * Given n online courses represented by pairs (t,d), your task is to find the
 * maximal number of courses that can be taken.
 * 
 * Example:
 * 
 * 
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * Explanation: 
 * There're totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the
 * 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the
 * 1100th day, and ready to take the next course on the 1101st day. 
 * Third, take the 2nd course, it costs 200 days so you will finish it on the
 * 1300th day. 
 * The 4th course cannot be taken now, since you will finish it on the 3300th
 * day, which exceeds the closed date.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The integer 1 <= d, t, n <= 10,000.
 * You can't take two courses simultaneously.
 * 
 * 
 * 
 * 
 */
/* TLE: Replace the longest duration course takes O(n^2)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
	List<Integer> pool = new LinkedList<>();
        for (int[] course : courses) {
	    pool.add(course[0]);
	    int[] poolInfo = getSumAndMaxItemIndex(pool);
	    if (poolInfo[0] > course[1]) {
		pool.remove(poolInfo[1]);
	    }
	}
	return pool.size();
    }

    // result[sum, index]
    private int[] getSumAndMaxItemIndex(List<Integer> pool) {
	int[] data = new int[2];
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < pool.size(); i++) {
	    if (pool.get(i) > max) {
		max = pool.get(i);
		data[1] = i;
	    }
	    data[0] += pool.get(i);
	}
	return data;
    }
}*/
class Solution {
    public int scheduleCourse(int[][] courses) {
	Arrays.sort(courses, (a, b) -> a[1] - b[1]);
	PriorityQueue<Integer> selectedPool = new PriorityQueue<>((a, b) -> b - a);
	int due = 0;
	for (int[] course : courses) {
	    if (due + course[0] <= course[1]) {
		selectedPool.offer(course[0]);
		due += course[0];
	    } else if(!selectedPool.isEmpty() && selectedPool.peek() > course[0]) {
		due += course[0] - selectedPool.poll();
		selectedPool.offer(course[0]);
	    }
	}
	return selectedPool.size();
    }
}
