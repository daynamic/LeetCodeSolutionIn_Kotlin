package com.akshat.leetcodesolutioninkotlin

/**
 * Regular Expression Matching
 *Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.* */



val s ="aa"
val p ="a*"

val result = isMatch(s,p)
println("the result is $result")


fun isMatch(s: String, p: String): Boolean {
    val n = s.length
    val m = p.length
    return solve(n - 1, m - 1, s, p)
}

fun solve(i: Int, j: Int, s: String, p: String): Boolean {
    if (j < 0) {
        return i < 0
    }
    if (i < 0) {
        return p[j] == '*' && solve(i, j - 2, s, p)
    }
    // simple char matching
    // if s char matchs with p char or it can be '.'
    if (s[i] == p[j] || p[j] == '.') {
        return solve(i - 1, j - 1, s, p)
    }
    return if (p[j] == '*') {
        // if s char matches with p char or it can be '.'
        if (s[i] == p[j - 1] || p[j - 1] == '.') {
            solve(i - 1, j, s, p) || solve(i, j - 2, s, p)
        } else {
            solve(
                i,
                j - 2,
                s,
                p
            )
        }
    } else {
        false
    }
}