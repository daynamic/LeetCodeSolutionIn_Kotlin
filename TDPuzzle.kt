package com.akshat.leetcodesolutioninkotlin.LeetCodeSolutionIn_Kotlin

/**
 * Question:
 * Let's consider something a user spends money on a "payee".
 * You are given [Map] of users and a list of payees the user has made payments to. EG:
 * mostFrequentPayees: Map<String, List<String>> = {
 *    "Bob": [ "Bell Canada", "Tim Hortons", "Amazon" ],
 *    "Alex": [ "Starbucks", "Netflix", "Tim Hortons" ]
 * }
 *
 * You are given a list of categories and the payees associated with them. EG:
 * categoryOfPayees: Map<String, List<String>> = {
 *     "Phone": [ "Bell Canada" ],
 *     "TV": [ "Bell Canada", "Netflix" ],
 *     "Entertainment": [ "Bell Canada", "Netflix", "Amazon" ],
 *     "Beverages": [ "Tim Hortons", "Starbucks" ],
 *     "Fast Food": [ "Tim Hortons", "Starbucks" ],
 * }
 *
 * Your job is to return a [Map] (of type Map<String, List<String>>) of the most frequent categories that the user spends money on.
 * EG:
 * Output = {
 *     "Bob": [ "Entertainment" ],
 *     "Alex": [ "Beverages", "Fast Food" ]
 * }
 */

private fun findMostFrequentCategories(
    mostFrequentPayees: Map<String, List<String>>,
    categoryOfPayees: Map<String, List<String>>
): Map<String, List<String>> {
    return HashMap()
}

private fun findMostFrequentCategoriesForPayee(
    payments: List<String>,
    categoryOfPayees: Map<String, List<String>>
): List<String> {
    return ArrayList()
}

fun main() {
    val mostFrequentPayees: Map<String, List<String>> =
        mapOf(
            "Bob" to listOf("Bell Canada", "Tim Hortons", "Amazon"),
            "Alex" to listOf("Starbucks", "Netflix", "Tim Hortons")
        )

    val categoryOfPayees: Map<String, List<String>> =
        mapOf(
            "Phone" to listOf("Bell Canada"),
            "TV" to listOf("Bell Canada", "Netflix"),
            "Entertainment" to listOf("Bell Canada", "Netflix", "Amazon"),
            "Beverages" to listOf("Tim Hortons", "Starbucks"),
            "Fast Food" to listOf("Tim Hortons", "Starbucks")
        )

    val map1 = mutableMapOf<String, String>()
    val list = mutableListOf<String>()
    for (payee in mostFrequentPayees) {
        list.removeAll(list)
        var counter = 0
        for (category in categoryOfPayees) {
            val listSize = payee.value.intersect(category.value.toSet()).size

            if (listSize == counter && counter != 0) {
                list.add(category.key)
            } else if (listSize > counter) {
                list.removeAll(list)
                list.add(category.key)
                counter = listSize
            }
        }
        map1.putIfAbsent(payee.key, list.toString())
        println(map1)
    }

}



