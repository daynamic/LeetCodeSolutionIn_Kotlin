package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 * n == height.length
 * 1 <= n <= 2 * 1040 <= height[i] <= 105
 *
 *
 * */

val height : IntArray = intArrayOf(4,2,0,3,2,5)
val totalWater = trap(height)
println("number is $totalWater")

fun trap(height: IntArray): Int {
    val size = height.size
    var maxLeft = 0
    var maxRight = 0
    var totalWater = 0
    var leftPtr = 0
    var rightPtr = size - 1
    while (leftPtr < rightPtr) {
        if (height[leftPtr] <= height[rightPtr]) {
            if (maxLeft > height[leftPtr]) {
                totalWater = totalWater + maxLeft - height[leftPtr]
            } else {
                maxLeft = height[leftPtr]
            }
            ++leftPtr
        } else {
            if (maxRight > height[rightPtr]) {
                totalWater = totalWater + maxRight - height[rightPtr]
            } else {
                maxRight = height[rightPtr]
            }
            --rightPtr
        }
    }
    return totalWater
}