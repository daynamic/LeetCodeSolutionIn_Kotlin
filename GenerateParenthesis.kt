package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 *
 *
 * */

val n = 3
val result = generateParenthesis(n)

for (obj in result){
    println(obj)
}

fun generateParenthesis(n: Int): List<String> {
    val sb = StringBuilder()
    val ans: MutableList<String> = ArrayList()
    return generate(sb, ans, n, n)
}

fun generate(sb: StringBuilder, str: MutableList<String>, open: Int, close: Int): List<String> {
    if (open == 0 && close == 0) {
        str.add(sb.toString())
        return str
    }
    if (open > 0) {
        sb.append('(')
        generate(sb, str, open - 1, close)
        sb.deleteCharAt(sb.length - 1)
    }
    if (close > 0 && open < close) {
        sb.append(')')
        generate(sb, str, open, close - 1)
        sb.deleteCharAt(sb.length - 1)
    }
    return str
}