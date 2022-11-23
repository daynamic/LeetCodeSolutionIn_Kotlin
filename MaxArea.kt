package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin


/**
 * Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 2:

Input: height = [1,1]
Output: 1

 *
 * */



val nums : IntArray = intArrayOf(1,8,6,2,5,4,8,3,7)
val result = maxArea(nums)
println("the result is $result")



fun maxArea(height: IntArray): Int {
    var max = 0
    if (height.isNotEmpty()) {
        var left = 0
        var right = height.size - 1
        while (left < right) {
            // next two if conditions are to make sure there are two non-zero containers to
            // hold water. If not move next to find one
            if (height[left] == 0) {
                left++
                continue
            }
            if (height[right] == 0) {
                right--
                continue
            }
            // if control came here that means left and right containers are non zero and
            // can hold water. Get the count of containers and multiple by lower container
            if (height[left] < height[right]) {
                max = Math.max(max, (right - left) * height[left])
                left++
            } else {
                max = Math.max(max, (right - left) * height[right])
                right--
            }
        }
    }
    return max
}