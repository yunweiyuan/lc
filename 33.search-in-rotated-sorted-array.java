/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.51%)
 * Total Accepted:    353.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {
		return -1;
	}
	int start = 0, end = nums.length - 1;
	while (start + 1 < end) {
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (nums[start] < nums[mid]) {
			if (target >= nums[start] && target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (nums[mid] < nums[end]) {
			if (target <= nums[end] && target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}
	if (target == nums[start]) {
		return start;
	} 
        if (target == nums[end]) {
		return end;
	}
	return -1;
    }
}
