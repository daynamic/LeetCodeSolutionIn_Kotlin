package com.akshat.leetcodesolutioninkotlin

/**
 * Reverse Integer
 *
 *Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1 * */

val x = 123
val result = reverse(x)
println("the result is $result")

fun reverse(x: Int): Int {
    var rev: Long = 0
    var localX = x
    while (localX != 0) {
        rev = (rev * 10) + (localX % 10)
        localX /= 10
    }
    if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
        return 0
    }
    return rev.toInt()
}