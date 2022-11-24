package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 *
 * */



val dividend = 10
val divisor = 3
val result = divide(dividend, divisor)
println("the result is $result")


fun divide(dividend: Int, divisor: Int): Int {
    val isNegative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0
    var ans: Long = 0
    var divide = Math.abs(dividend.toLong())
    val divisorAbs = Math.abs(divisor.toLong())
    while (divide >= divisorAbs) {
        var temp = divisorAbs
        var cnt: Long = 1
        while (divide >= temp) {
            divide -= temp
            ans += cnt
            cnt = cnt shl 1
            temp = temp shl 1
        }
    }
    if (isNegative) {
        ans = -ans
    }
    val intMin = -(1 shl 31)
    val intMax = (1 shl 31) - 1
    if (ans < intMin || ans > intMax) {
        ans = intMax.toLong()
    }
    return ans.toInt()
}