package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Merge k Sorted Lists
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 *
 * */

fun mergeKLists(lists: Array<ListNode>): ListNode? {
    return if (lists.isEmpty()) {
        null
    } else mergeKLists(lists, 0, lists.size)
}

private fun mergeKLists(lists: Array<ListNode>, leftIndex: Int, rightIndex: Int): ListNode? {
    return if (rightIndex > leftIndex + 1) {
        val mid = (leftIndex + rightIndex) / 2
        val left = mergeKLists(lists, leftIndex, mid)
        val right = mergeKLists(lists, mid, rightIndex)
        mergeTwoLists(left, right)
    } else {
        lists[leftIndex]
    }
}

private fun mergeTwoLists(leftLocal: ListNode?, rightLocal: ListNode?): ListNode? {
    var left = leftLocal
    var right = rightLocal
    if (left == null) {
        return right
    }
    if (right == null) {
        return left
    }
    val res: ListNode
    if (left.`val` <= right.`val`) {
        res = left
        left = left.next
    } else {
        res = right
        right = right.next
    }
    var node: ListNode? = res
    while (left != null || right != null) {
        if (left == null) {
            node!!.next = right
            right = right!!.next
        } else if (right == null) {
            node!!.next = left
            left = left.next
        } else {
            if (left.`val` <= right.`val`) {
                node!!.next = left
                left = left.next
            } else {
                node!!.next = right
                right = right.next
            }
        }
        node = node.next
    }
    return res
}