package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 *
 * */



val nums = intArrayOf(-1,0,1,2,-1,-4)
val result = threeSum(nums)

for (obj in result){
    println(obj)
}


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val len = nums.size
    val result: MutableList<List<Int>> = ArrayList()
    var l: Int
    var r: Int
    var i = 0
    while (i < len - 2) {
        l = i + 1
        r = len - 1
        while (r > l) {
            val sum = nums[i] + nums[l] + nums[r]
            if (sum < 0) {
                l++
            } else if (sum > 0) {
                r--
            } else {
                val list: MutableList<Int> = ArrayList()
                list.add(nums[i])
                list.add(nums[l])
                list.add(nums[r])
                result.add(list)
                while (l < r && nums[l + 1] == nums[l]) {
                    l++
                }
                while (r > l && nums[r - 1] == nums[r]) {
                    r--
                }
                l++
                r--
            }
        }
        while (i < len - 1 && nums[i + 1] == nums[i]) {
            i++
        }
        i++
    }
    return result
}