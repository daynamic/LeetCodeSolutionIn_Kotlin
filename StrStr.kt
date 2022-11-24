package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 *
 * */



val haystack ="butsadsad"
val needle ="sad"
val result = strStr(haystack, needle)
println("the result is $result")


fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) {
        return 0
    }
    val m = haystack.length
    val n = needle.length
    for (start in 0 until m - n + 1) {
        if (haystack.substring(start, start + n) == needle) {
            return start
        }
    }
    return -1
}