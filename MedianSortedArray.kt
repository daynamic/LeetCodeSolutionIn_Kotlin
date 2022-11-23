package com.akshat.leetcodesolutioninkotlin

/**
 * Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 * */


val arr1 : IntArray = intArrayOf(1,2)
val arr2 : IntArray = intArrayOf(3,4)

val result = findMedianSortedArrays(arr1, arr2)
println("the result is $result")


fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val l: MutableList<Int> = ArrayList()
    val f: Double
    for (j in nums1) {
        l.add(j)
    }
    for (i in nums2) {
        l.add(i)
    }
    l.sort()
    val k = l.size
    f = if (k % 2 == 0) {
        (l[k / 2 - 1] + l[k / 2]).toDouble() / 2
    } else {
        l[(k + 1) / 2 - 1].toDouble()
    }
    return f
}