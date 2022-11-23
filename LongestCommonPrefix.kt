package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 *
 * */

val arr1 = arrayOf("flower","flow","flight")
val result = longestCommonPrefix(arr1)
println("the result is $result")

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    if (strs.size == 1) {
        return strs[0]
    }
    var temp = strs[0]
    var i = 1
    var cur: String
    while (temp.length > 0 && i < strs.size) {
        if (temp.length > strs[i].length) {
            temp = temp.substring(0, strs[i].length)
        }
        cur = strs[i].substring(0, temp.length)
        if (cur != temp) {
            temp = temp.substring(0, temp.length - 1)
        } else {
            i++
        }
    }
    return temp
}