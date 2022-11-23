package com.akshat.leetcodesolutioninkotlin

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/



val s = "abcabcbb"
val result = lengthOfLongestSubstring(s)
println("result is $result")

fun lengthOfLongestSubstring(s: String): Int {
    var i = 0
    var j = 0
    var longest = 0
    // 1. if string empty, return 0
    if (s.isEmpty()) {
        return 0
    }
    while (j < s.length) {
        // 2. if the char at index j already seen, update the longest if needs
        if (i != j && s.substring(i, j).indexOf(s[j]) > -1) {
            longest = Math.max(j - i, longest)
            i++
        } else {
            // 3. j out of bound already, update longest
            if (++j == s.length) {
                longest = Math.max(s.length - i, longest)
                break
            }
        }
    }
    return longest
}